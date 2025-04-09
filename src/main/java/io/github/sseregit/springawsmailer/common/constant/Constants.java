package io.github.sseregit.springawsmailer.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {
	public static final String COMMON_MAIL_SENDER = "sseregitjys@gmail.com";
	public static final String OTP_ISSUER = "sseregit";
	// QR코드를 위한 API Router
	public static final String QR_SERVER = "https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=otpauth://totp/%s:%s?secret=%s&issuer=%s";
	public static final String INVITE_QR_TEMPLATE = "invite-opt-code";
	public static final String SECRETKEY = "SECRETKEY";
}

