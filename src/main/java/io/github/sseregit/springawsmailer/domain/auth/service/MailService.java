package io.github.sseregit.springawsmailer.domain.auth.service;

import static io.github.sseregit.springawsmailer.common.code.ErrorCode.*;
import static io.github.sseregit.springawsmailer.common.constant.Constants.*;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import io.github.sseregit.springawsmailer.common.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.Destination;
import software.amazon.awssdk.services.ses.model.SendTemplatedEmailRequest;
import software.amazon.awssdk.services.ses.model.SendTemplatedEmailResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailService {

	private final SesClient sesClient;

	void sendTemplatedEmail(String templateName, Map<String, String> templateData, String... receivers) {
		if (receivers.length == 0) {
			throw new CustomException(MAIL_RECEIVER_REQUIRED);
		}

		SendTemplatedEmailResponse response = sesClient.sendTemplatedEmail(
			SendTemplatedEmailRequest.builder()
				.source(COMMON_MAIL_SENDER)
				.destination(Destination.builder()
					.toAddresses(receivers)
					.build())
				.template(templateName)
				.templateData(new Gson().toJson(templateData))
				.build()
		);

		log.info("send Templated({}) email to : {}", templateName, String.join(",", receivers));

		if (!response.sdkHttpResponse().isSuccessful()) {
			throw new CustomException(MAIL_SEND_FAILED, response.sdkHttpResponse().toString());
		}
	}
}
