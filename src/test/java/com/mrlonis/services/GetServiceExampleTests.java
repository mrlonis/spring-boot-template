package com.mrlonis.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mrlonis.dto.GetMethodExampleResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class GetServiceExampleTests {
    @InjectMocks
    GetServiceExample getServiceExample;

    @Test
    public void shouldReturn200_whenProvided200StatusCode() {
        int statusCode = 200;

        GetMethodExampleResponse expected = GetMethodExampleResponse.builder()
                                                                    .statusCode(statusCode)
                                                                    .message(HttpStatus.OK.toString())
                                                                    .build();

        GetMethodExampleResponse actual = getServiceExample.getMethodExampleResponse(statusCode);

        assertEquals(expected, actual);
    }
}
