package cn.zoowayss.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.zoowayss.demo.entity.User;
import cn.zoowayss.demo.mapper.UserMapper;
import cn.zoowayss.demo.service.UserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}
