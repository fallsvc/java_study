package org.example.pspringboot;

import jdk.jfr.Registered;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
