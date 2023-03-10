package cn.zoowayss.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Author: Zuwayss Shi
 * @Date: 2023/3/10 09:42
 * @Version: 1.0
 */

@SpringBootApplication
@MapperScan("cn.zoowayss.demo.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
