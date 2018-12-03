package com.cp.chisana.exception;

/**
 * Created by Chandra.Sarathe on 12/2/2018.
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
