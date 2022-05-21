package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http://localhost:9090/api/get/hello
    public String getHello(){
        return "get Hello";
    }

    //옛날 방식
    @RequestMapping(path = "/hi", method = RequestMethod.GET) //get http://localhost:9090/api/get/hi
       public String hi(){
        return "hi";
    }

    //http://localhost:9090/api/get/path-variable/{name}

    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){

        System.out.println("PathVariable : "+ pathName);

        return pathName;
    }

    //search?q=intellij&oq=intellij
    // &aqs = chrome.0.69i59j0i512l2j0i131i433i512j0i512l4j0i131i433i512j0i512.3308j0j7
    // &sourceid = chrome
    // &ie = UTF-8
    // &safe = active
    // &ssui = on

    // ?key = value&key2 = value2

    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30

    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String,String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
            System.out.println("\n");

            sb.append(key).append(" = ").append(value).append("\n");
        });


        return sb.toString();
    }
}
