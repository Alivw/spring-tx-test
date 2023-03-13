package cn.zoowayss.demo.service.impl;

import cn.zoowayss.demo.entity.User;
import cn.zoowayss.demo.mapper.UserMapper;
import cn.zoowayss.demo.service.OtherService;
import cn.zoowayss.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.*;
import java.io.IOException;
import java.util.Random;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private OtherService otherService;

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


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void required() {
        log.info("do required....");
        baseMapper.insert(new User(null, "zoowayss", 18));
        int a = 10 / 0;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void supports() {
        log.info("do supports");
        baseMapper.insert(new User(null, "zoowayss", 18));
        int a = 10 / 0;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void mandatory() {
        log.info("do mandatory");
        baseMapper.insert(new User(null, "zoowayss", 18));
        int a = 10 / 0;
    }

    @Transactional
    @Override
    public void RequiresNew() {
        log.info("do RequiresNew");
        try {
            otherService.doInsertRequired();
        } catch (Exception e) {
            log.error("", e);
        }
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public void notSupported() {
        log.info("do notSupported");
    }

    @Transactional(propagation = Propagation.NEVER)
    @Override
    public void never() {
        log.info("do never");
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void nested() {
        log.info("do nested");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void requiredNotThrowEx() {
        baseMapper.insert(new User(null, "zoowayss", 18));
    }
}
