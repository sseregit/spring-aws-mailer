package io.github.sseregit.springawsmailer.domain.auth.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "OTP 전송 요청")
public record SendOTPRequest(
    @Schema(description = "이메일")
    @NotBlank
    String email
) {

}
