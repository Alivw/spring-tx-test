package cn.zoowayss.demo.controller;

import cn.zoowayss.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description:
 * @Author: Zuwayss Shi
 * @Date: 2023/3/10 10:04
 * @Version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/tx/ex")
public class ExController {
    @Resource
    private UserService userService;

    /**
     * throws unchecked exception
     *
     * @return
     */
    @GetMapping("/rollback/unchecked")
    public String rollback() {
        userService.rollback();
        return "ok";
    }

    /**
     * throws checked exception
     *
     * @return
     */
    @GetMapping("/rollback/checked")
    public String rollbackChecked() {
        try {
            userService.rollbackChecked();
        } catch (IOException e) {
            log.error("/rollback/checked", e);
            return "error";
        }
        return "ok";
    }

    @GetMapping("/rollback/checked/for")
    public String rollbackCheckedFor() {
        try {
            userService.rollbackCheckedFor();
        } catch (IOException e) {
            log.error("/rollback/checked", e);
            return "error";
        }
        return "ok";
    }
}
