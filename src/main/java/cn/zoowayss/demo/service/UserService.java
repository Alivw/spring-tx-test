package cn.zoowayss.demo.service;

import cn.zoowayss.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;

public interface UserService extends IService<User> {


    void rollback();

    void rollbackChecked() throws IOException;

    void rollbackCheckedFor() throws IOException;
}
