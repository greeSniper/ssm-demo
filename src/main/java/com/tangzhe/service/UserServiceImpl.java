package com.tangzhe.service;

import com.tangzhe.dao.UserMapper;
import com.tangzhe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试通过id查询用户
     */
    public User findById(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
