package com.mrlonis.controllers;

import com.mrlonis.dto.GetMethodExampleResponse;
import com.mrlonis.services.GetServiceExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/getTemplate")
@Api(tags = {"Get Template"})
public class GetControllerExample {

    private final GetServiceExample getServiceExample;

    @Autowired
    public GetControllerExample(GetServiceExample getServiceExample) {
        this.getServiceExample = getServiceExample;
    }

    @ResponseBody
    @GetMapping(path = "/getMethodExample", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "GET", value = "Example GET Method", response = GetMethodExampleResponse.class)
    public GetMethodExampleResponse getMethodExample(@RequestParam(name = "statusCode") int statusCode) {
        return getServiceExample.getMethodExampleResponse(statusCode);
    }

}
