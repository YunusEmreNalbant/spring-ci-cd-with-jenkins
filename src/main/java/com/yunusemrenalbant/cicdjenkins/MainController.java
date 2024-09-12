package com.yunusemrenalbant.cicdjenkins;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MainController {

    @GetMapping("/")
    public String hello() {
        return "Nothing to see here. Move along....";
    }
}