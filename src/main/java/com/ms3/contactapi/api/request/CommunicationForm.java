package com.ms3.contactapi.api.request;

import lombok.Data;

@Data
public class CommunicationForm {
    private String type;
    private String value;
    private boolean preferred;
}
