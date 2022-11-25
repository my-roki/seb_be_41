package com.codestates.hello_oauth2.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloHomeController {
    @GetMapping("/hello-oauth2")
    public String home() {
        return "hello-oauth2";
    }
}