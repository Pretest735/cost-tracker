package com.mirbag.costtracker.utilities;

import org.springframework.stereotype.Service;

@Service
public class UtilityFunctionImpl implements UtilityFunctions{

    @Override
    public <T> ResponseModel generateResponse(String status, String message, T data) {
        ResponseModel<T> responseModel = new ResponseModel<>();
        responseModel.setStatus(status);
        responseModel.setMessage(message);
        responseModel.setData(data);
        return responseModel;
    }
}
