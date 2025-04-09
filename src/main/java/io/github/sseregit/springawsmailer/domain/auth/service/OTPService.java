package io.github.sseregit.springawsmailer.domain.auth.service;

import static io.github.sseregit.springawsmailer.common.code.ErrorCode.*;
import static io.github.sseregit.springawsmailer.common.constant.Constants.*;

import java.util.Map;

import org.springframework.stereotype.Service;

import io.github.sseregit.springawsmailer.common.exception.CustomException;
import io.github.sseregit.springawsmailer.common.validator.EmailValidator;
import io.github.sseregit.springawsmailer.domain.auth.model.request.SendOTPRequest;
import io.github.sseregit.springawsmailer.domain.auth.model.response.SendOTPResponse;
import io.github.sseregit.springawsmailer.domain.repository.UserRepository;
import io.github.sseregit.springawsmailer.domain.repository.entity.User;
import io.github.sseregit.springawsmailer.security.OTP;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OTPService {

    private final UserRepository userRepository;
    private final MailService mailService;

    public SendOTPResponse sendOTP(SendOTPRequest request) {
        String email = request.email();

        if (!EmailValidator.isValidEmail(email)) {
            throw new CustomException(NOT_VALID_EMAIL_REQUEST);
        }

        User user = userRepository.findByEmail(email)
            .orElseGet(() -> userRepository.save(User.builder().email(email).isValid(false).build()));

        log.info("Get From DB {}", user.getEmail());

        if (!user.getIsValid()) {
            String link = OTP.generateQRCodeURL(email, SECRETKEY);

            Map<String, String> data = Map.of(
                "email", email,
                "link", link
            );

            mailService.sendTemplatedEmail(INVITE_QR_TEMPLATE, data, email);
        }

        return new SendOTPResponse(email);
    }

}
