package com.mrlonis.services;

import com.mrlonis.dto.PostMethodExampleRequest;
import com.mrlonis.dto.PostMethodExampleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PostServiceExample {

    @Autowired
    public PostServiceExample() {

    }

    public PostMethodExampleResponse postServiceExample(PostMethodExampleRequest request) {
        return PostMethodExampleResponse.builder()
                                        .statusCode(request.getStatusCode())
                                        .message(HttpStatus.OK.toString())
                                        .build();
    }
}
