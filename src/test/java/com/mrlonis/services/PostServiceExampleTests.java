package com.mrlonis.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mrlonis.dto.PostMethodExampleRequest;
import com.mrlonis.dto.PostMethodExampleResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class PostServiceExampleTests {
    @InjectMocks
    PostServiceExample postServiceExample;

    @Test
    public void shouldReturn200_whenProvided200StatusCode() {
        int statusCode = 200;

        PostMethodExampleRequest request = PostMethodExampleRequest.builder()
                                                                   .statusCode(statusCode)
                                                                   .build();

        PostMethodExampleResponse expected = PostMethodExampleResponse.builder()
                                                                     .statusCode(statusCode)
                                                                     .message(HttpStatus.OK.toString())
                                                                     .build();

        PostMethodExampleResponse actual = postServiceExample.postServiceExample(request);

        assertEquals(expected, actual);
    }
}
