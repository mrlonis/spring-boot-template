package com.mrlonis.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.mrlonis.dto.GetMethodExampleResponse;
import com.mrlonis.services.GetServiceExample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class GetControllerExampleTests {
    @InjectMocks
    GetControllerExample getControllerExample;

    @Mock
    GetServiceExample getServiceExample;

    @Test
    public void shouldReturn200_whenProvided200StatusCode() {
        int statusCode = 200;

        GetMethodExampleResponse expected = GetMethodExampleResponse.builder()
                                                                    .statusCode(statusCode)
                                                                    .message(HttpStatus.OK.toString())
                                                                    .build();

        when(getServiceExample.getMethodExampleResponse(statusCode)).thenReturn(expected);

        GetMethodExampleResponse actual = getControllerExample.getMethodExample(statusCode);

        assertEquals(expected, actual);
    }
}
