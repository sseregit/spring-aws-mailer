package io.github.sseregit.springawsmailer.common.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements CInterface {
	NOT_VALID_EMAIL_REQUEST(-1, "잘못된 이메일 형식 입니다."),
	;

	private final Integer code;
	private final String message;

}
