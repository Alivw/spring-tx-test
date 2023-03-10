package cn.zoowayss.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Zuwayss Shi
 * @Date: 2023/3/10 09:58
 * @Version: 1.0
 */

@RestController
@RequestMapping("/tx")
public class TestController {

    @GetMapping
    public String hello() {
        return "hello world!";
    }
}
