package com.mrlonis.services;

import com.mrlonis.dto.GetMethodExampleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GetServiceTemplate {

    @Autowired
    public GetServiceTemplate() {

    }

    public GetMethodExampleResponse getMethodExampleResponse(int statusCode) {
        return GetMethodExampleResponse.builder()
                                       .statusCode(statusCode)
                                       .message(HttpStatus.OK.toString())
                                       .build();
    }

}
