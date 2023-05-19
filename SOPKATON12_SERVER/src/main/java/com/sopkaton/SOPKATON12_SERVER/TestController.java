package com.sopkaton.SOPKATON12_SERVER;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public String testController() {
        return "테스트 성공";
    }
}
