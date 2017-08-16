package com.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SourcingController {

    @RequestMapping("/sourcing/test")
    public String test() {
        System.out.println("This is testing");
        return "test";
    }
}
