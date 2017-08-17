package com.api;

import com.sourcing.Sourcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SourcingController {
    @Autowired
    private Sourcer sourcer;

    @RequestMapping("/sourcing/test")
    public void test() {
        System.out.println("Sourcing to see if this works");
        sourcer.sourceItems();
    }
}
