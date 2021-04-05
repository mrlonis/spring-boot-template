package com.mrlonis.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.mrlonis.dto.GetMethodExampleResponse;
import com.mrlonis.services.GetServiceTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class GetControllerTemplateTests {
    @InjectMocks
    GetControllerTemplate getControllerTemplate;

    @Mock
    GetServiceTemplate getServiceTemplate;

    @Test
    public void shouldReturn200_whenProvided200StatusCode() {
        int statusCode = 200;

        GetMethodExampleResponse expected = GetMethodExampleResponse.builder()
                                                                    .statusCode(statusCode)
                                                                    .message(HttpStatus.OK.toString())
                                                                    .build();

        when(getServiceTemplate.getMethodExampleResponse(statusCode)).thenReturn(expected);

        GetMethodExampleResponse actual = getControllerTemplate.getMethodExample(statusCode);

        assertEquals(expected, actual);
    }
}
