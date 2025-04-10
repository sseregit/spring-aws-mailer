package io.github.sseregit.springawsmailer.domain.auth.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.sseregit.springawsmailer.domain.auth.model.request.SendOTPRequest;
import io.github.sseregit.springawsmailer.domain.auth.model.response.SendOTPResponse;
import io.github.sseregit.springawsmailer.domain.auth.service.OTPService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Account API", description = "계정 관련 API")
@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
@Slf4j
@Validated
class AccountController {

    private final OTPService otpService;

    @Operation(
        summary = "Email OTP 전송",
        description = "Email에 OTP를 전송한다."
    )
    @GetMapping("/make-user/{email}")
    SendOTPResponse sendOTP(@PathVariable @NotBlank String email) {
        return otpService.sendOTP(new SendOTPRequest(email));
    }
}
