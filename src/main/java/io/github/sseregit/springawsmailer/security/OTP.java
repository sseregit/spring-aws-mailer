package io.github.sseregit.springawsmailer.security;

import static io.github.sseregit.springawsmailer.common.constant.Constants.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OTP {
	public static String generateQRCodeURL(String email, String secretKey) {
		return String.format(
			QR_SERVER,
			URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8),
			URLEncoder.encode(email, StandardCharsets.UTF_8),
			URLEncoder.encode(secretKey, StandardCharsets.UTF_8),
			URLEncoder.encode(OTP_ISSUER, StandardCharsets.UTF_8)
		);
	}
}
