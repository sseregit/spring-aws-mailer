package io.github.sseregit.springawsmailer.domain.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.sseregit.springawsmailer.domain.auth.model.request.SendOTPRequest;
import io.github.sseregit.springawsmailer.domain.auth.model.response.SendOTPResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Account API", description = "계정 관련 API")
@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
class AccountController {

	@Operation(
		summary = "Email OTP 전송",
		description = "Email에 OTP를 전송한다."
	)
	@GetMapping("/make-user/{email}")
	SendOTPResponse sendOTP(@RequestBody @Valid SendOTPRequest request) {
		return null;
	}
}
