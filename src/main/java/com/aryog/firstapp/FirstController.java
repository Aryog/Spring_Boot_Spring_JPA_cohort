package com.aryog.firstapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from my first controller";
    }
    @PostMapping("/post")
    public String post(@RequestBody String message){
        return "Request accepted and message is: "+message;
    }
    @PostMapping("/post-order")
    public String post(@RequestBody Order order){
        return "Request accepted and message is: "+order.toString();
    }
}
