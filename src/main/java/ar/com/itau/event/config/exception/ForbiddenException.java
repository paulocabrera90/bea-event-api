package ar.com.itau.event.config.exception;

import ar.com.itau.event.config.ErrorCode;

public final class ForbiddenException extends GenericException {

    public ForbiddenException(ErrorCode errorCode) {
        super(errorCode);
    }

}
