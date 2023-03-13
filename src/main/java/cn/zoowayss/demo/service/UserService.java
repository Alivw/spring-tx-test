package cn.zoowayss.demo.service;

import cn.zoowayss.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @Description:
 * @Author: Zuwayss Shi
 * @Date: 2023/3/13 11:29
 * @Version: 1.0
 */

public interface UserService extends IService<User> {
    @Transactional
    void rollback();

    @Transactional
    void rollbackChecked() throws IOException;

    @Transactional(rollbackFor = Exception.class)
    void rollbackCheckedFor() throws IOException;

    @Transactional(propagation = Propagation.REQUIRED)
    void required();

    @Transactional(propagation = Propagation.SUPPORTS)
    void supports();

    @Transactional(propagation = Propagation.MANDATORY)
    void mandatory();

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void RequiresNew();

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    void notSupported();

    @Transactional(propagation = Propagation.NEVER)
    void never();

    @Transactional(propagation = Propagation.NESTED)
    void nested();

    void requiredNotThrowEx();
}
