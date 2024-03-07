package com.aryog.firstapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
//    @GetMapping("/hello")
//    public String sayHello(){
//        return "Hello from my first controller";
//    }
    @PostMapping("/post")
    public String post(@RequestBody String message){
        return "Request accepted and message is: "+message;
    }
    @PostMapping("/post-order")
    public String post(@RequestBody Order order){
        return "Request accepted and message is: "+order.toString();
    }
    // Using the Record order
    @PostMapping("/order-record")
    public String postRecord(@RequestBody OrderRecord order){
        return "Request accepted and message is: "+order.toString();
    }

    // http://localhost:8080/hello/yogesh
    @GetMapping("/hello/{user-name}")
    public String pathVar(@PathVariable("user-name") String userName){
        return "my value = "+userName;
    }

    // http://localhost:8080/hello?param_name=paramvalue&param_name_1=value_2
    @GetMapping("/hello")
    public String paramVar(@RequestParam("user-name") String userName,
                           @RequestParam("user-lastname") String userLastname){
        return "my value = "+userName+" "+userLastname;
    }
}
