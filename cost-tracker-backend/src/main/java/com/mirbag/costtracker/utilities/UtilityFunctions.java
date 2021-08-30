package com.mirbag.costtracker.utilities;

public interface UtilityFunctions {
    public <T> ResponseModel generateResponse(String status, String message, T data);
}
