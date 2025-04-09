package io.github.sseregit.springawsmailer.domain.auth.service;

import org.springframework.stereotype.Service;

import io.github.sseregit.springawsmailer.domain.auth.model.request.SendOTPRequest;
import io.github.sseregit.springawsmailer.domain.auth.model.response.SendOTPResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OTPService {

	public SendOTPResponse sendOTP(SendOTPRequest request) {
		String email = request.email();

		return new SendOTPResponse(email);
	}

}
