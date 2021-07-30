package com.ms3.contactapi.api.model;

import lombok.Data;

@Data
public class Communication {
    private String type;
    private String value;
    private boolean preferred;
}
