package com.mrlonis.controllers;

import com.mrlonis.dto.PostMethodExampleRequest;
import com.mrlonis.dto.PostMethodExampleResponse;
import com.mrlonis.services.PostServiceExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/postTemplate")
@Api(tags = {"Post Template"})
public class PostControllerExample {

    private final PostServiceExample postServiceExample;

    @Autowired
    public PostControllerExample(PostServiceExample postServiceExample) {
        this.postServiceExample = postServiceExample;
    }

    @ResponseBody
    @PostMapping(path = "/postMethodExample", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(httpMethod = "POST", value = "Example POST Method", response = PostMethodExampleResponse.class)
    public PostMethodExampleResponse postMethodExample(@RequestBody PostMethodExampleRequest postMethodExampleRequest) {
        return postServiceExample.postServiceExample(postMethodExampleRequest);
    }
}
