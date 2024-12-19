package com.phonebook.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class ErrorDto {

    private String timestamp;
    private int status;
    private String Error;
    private Object message;
    private String path;

}
