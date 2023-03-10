package cn.zoowayss.demo.service.impl;

import cn.zoowayss.demo.entity.User;
import cn.zoowayss.demo.mapper.UserMapper;
import cn.zoowayss.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Random;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Transactional
    @Override
    public void rollback() {
        baseMapper.insert(new User(null, "zoowayss", 18));
        if (new Random().nextBoolean()) {
            throw new RuntimeException("save user error");
        } else {
            log.info("save successful");
        }
    }

    @Transactional
    @Override
    public void rollbackChecked() throws IOException {
        baseMapper.insert(new User(null, "zoowayss", 18));
        if (new Random().nextBoolean()) {
            throw new IOException("save user error");
        } else {
            log.info("save successful");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void rollbackCheckedFor() throws IOException {
        baseMapper.insert(new User(null, "zoowayss", 18));
        if (new Random().nextBoolean()) {
            throw new IOException("save user error");
        } else {
            log.info("save successful");
        }
    }
}
