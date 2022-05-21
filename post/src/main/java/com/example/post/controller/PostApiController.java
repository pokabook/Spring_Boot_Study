package com.example.post.controller;

import com.example.post.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void  post(@RequestBody PostRequestDto requestData){
        System.out.println(requestData);
    }
}