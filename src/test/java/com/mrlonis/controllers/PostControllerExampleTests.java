package com.mrlonis.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.mrlonis.dto.PostMethodExampleRequest;
import com.mrlonis.dto.PostMethodExampleResponse;
import com.mrlonis.services.PostServiceExample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class PostControllerExampleTests {
    @InjectMocks
    PostControllerExample postControllerExample;

    @Mock
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

        when(postServiceExample.postServiceExample(request)).thenReturn(expected);

        PostMethodExampleResponse actual = postControllerExample.postMethodExample(request);

        assertEquals(expected, actual);
    }
}
