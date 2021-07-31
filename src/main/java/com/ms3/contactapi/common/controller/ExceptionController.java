package com.ms3.contactapi.common.controller;

import com.ms3.contactapi.common.constant.GeneralErrorInfo;
import com.ms3.contactapi.common.response.ErrorResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class ExceptionController {

    /**
     * Catch-all handler to make sure all error responses will take the
     * {@link ErrorResource} form.
     *
     * @param e Exception object to be sent to the logger.
     * @return {@link ErrorResource} representation of the exception.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResource handleException(Exception e) {
        log.warn("Uncaught exception", e);
        return new ErrorResource(GeneralErrorInfo.INTERNAL_SERVER_ERROR);
    }
}
