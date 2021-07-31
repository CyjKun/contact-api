package com.ms3.contactapi.common.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ms3.contactapi.common.constant.ErrorInfo;
import lombok.Data;

@Data
@JsonSerialize
public class ErrorResource {

    private String errorCode;
    private String message;

    public ErrorResource() {
    }

    public ErrorResource(ErrorInfo info) {
        this.errorCode = info.getCode();
        this.message = info.getMessage();
    }

    /**
     * Transforms this object to JSON string.
     * To be used outside spring controllers where jackson does not work.
     *
     * @return A JSON string with fields {@code errorCode} and {@code message}.
     */
    public String toJson() {
        return String.format("{\"errorCode\":\"%s\",\"message\":\"%s\"}", errorCode, message);
    }
}
