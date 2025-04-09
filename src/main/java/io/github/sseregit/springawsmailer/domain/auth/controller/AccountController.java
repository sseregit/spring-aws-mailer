package io.github.sseregit.springawsmailer.domain.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
	void sendOTP() {

	}
}
