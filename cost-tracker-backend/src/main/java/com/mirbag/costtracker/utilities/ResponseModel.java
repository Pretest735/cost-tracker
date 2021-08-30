package com.mirbag.costtracker.utilities;

import lombok.Data;

import java.util.Locale;
@Data
public class ResponseModel<T> {
    private String status;
    private String message;
    private T data;

}
