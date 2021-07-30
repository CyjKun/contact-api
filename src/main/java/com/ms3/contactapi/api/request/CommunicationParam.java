package com.ms3.contactapi.api.request;

import lombok.Data;

@Data
public class CommunicationParam {
    private String type;
    private String value;
    private boolean preferred;
}
