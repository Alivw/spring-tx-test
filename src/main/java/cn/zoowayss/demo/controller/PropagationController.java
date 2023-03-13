package cn.zoowayss.demo.controller;

import cn.zoowayss.demo.service.UserService;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: 关于事物传播行为测试控制器
 * @Author: Zuwayss Shi
 * @Date: 2023/3/13 11:34
 * @Version: 1.0
 */
@RestController
@RequestMapping("/tx/propagation")
public class PropagationController {

    @Resource
    private UserService userService;

    @GetMapping("/" + TransactionDefinition.PROPAGATION_REQUIRED)
    public String PROPAGATION_REQUIRED() {
        userService.required();
        return "ok";
    }

    @GetMapping("/" + TransactionDefinition.PROPAGATION_SUPPORTS)
    public String PROPAGATION_SUPPORTS() {
        userService.supports();
        return "ok";
    }

    @GetMapping("/" + TransactionDefinition.PROPAGATION_MANDATORY)
    public String PROPAGATION_MANDATORY() {
        userService.mandatory();
        return "ok";
    }

    @GetMapping("/" + TransactionDefinition.PROPAGATION_REQUIRES_NEW)
    public String PROPAGATION_REQUIRES_NEW() {
        userService.RequiresNew();
        return "ok";
    }

    @GetMapping("/" + TransactionDefinition.PROPAGATION_NOT_SUPPORTED)
    public String PROPAGATION_NOT_SUPPORTED() {
        userService.notSupported();
        return "ok";
    }

    @GetMapping("/" + TransactionDefinition.PROPAGATION_NEVER)
    public String PROPAGATION_NEVER() {
        userService.never();
        return "ok";
    }

    @GetMapping("/" + TransactionDefinition.PROPAGATION_NESTED)
    public String PROPAGATION_NESTED() {
        userService.nested();
        return "ok";
    }

}
