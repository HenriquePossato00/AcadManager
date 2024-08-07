package com.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
    
    @GetMapping("/hello")
    public String hello() {
        return "index";
    }
}
