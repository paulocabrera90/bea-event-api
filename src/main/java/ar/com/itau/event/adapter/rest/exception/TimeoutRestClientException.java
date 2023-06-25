package ar.com.itau.event.adapter.rest.exception;

import ar.com.itau.event.config.ErrorCode;
import ar.com.itau.event.config.exception.GenericException;

public final class TimeoutRestClientException extends GenericException {

    public TimeoutRestClientException(ErrorCode errorCode) {
        super(errorCode);
    }

}
