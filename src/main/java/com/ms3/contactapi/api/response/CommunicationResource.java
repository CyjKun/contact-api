package com.ms3.contactapi.api.response;

import lombok.Data;

@Data
public class CommunicationResource {
    private String type;
    private String value;
    private boolean preferred;
}
