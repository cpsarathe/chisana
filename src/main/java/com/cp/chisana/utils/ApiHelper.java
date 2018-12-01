package com.cp.chisana.utils;

import org.springframework.stereotype.Component;

import com.cp.chisana.dto.ResponseDTO;

@Component
public class ApiHelper {

    /**
     * generates consistent response for each endpoint
     * @param status
     * @param isSuccess
     * @param message
     * @param responseObj
     * @param <T>
     * @return
     */
    public <T> ResponseDTO<T> getApiResponse(int status,Boolean isSuccess,String message,T responseObj) {
        ResponseDTO<T> response = new ResponseDTO<>();
        if (responseObj != null) {
            response.setBody(responseObj);
        }
        response.setSuccess(isSuccess);
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }
}
