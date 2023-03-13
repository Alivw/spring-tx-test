package cn.zoowayss.demo.service.impl;

import cn.zoowayss.demo.entity.User;
import cn.zoowayss.demo.mapper.UserMapper;
import cn.zoowayss.demo.service.OtherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Zuwayss Shi
 * @Date: 2023/3/13 13:23
 * @Version: 1.0
 */
@Service
public class OtherServiceImpl implements OtherService {
    @Resource
    private UserMapper userMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void doInsertRequired() {
        userMapper.insert(new User(null, "zoowayss", 1));
        throw new RuntimeException();
    }
}
