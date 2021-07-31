package com.ms3.contactapi.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GeneralErrorInfo implements ErrorInfo {

    INTERNAL_SERVER_ERROR("Something went wrong in the servers. Please contact support."),
    ;

    @Getter
    private final String message;

    @Override
    public String getCode() {
        return name();
    }
}

