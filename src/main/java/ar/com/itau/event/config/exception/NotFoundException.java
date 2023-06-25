package ar.com.itau.event.config.exception;

import ar.com.itau.event.config.ErrorCode;

public final class NotFoundException extends GenericException {

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

}
