package com.shuai.service.impl;

import com.shuai.entity.User;
import com.shuai.entity.UserDetails;
import com.shuai.mapper.UserMapper;
import com.shuai.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
    }

    public Double QueryBalance(Integer id) {
        return this.userMapper.QueryBalance(id);
    }

    public Boolean Consumer100(User user) {
        boolean flag = false;
        Integer i = this.userMapper.Consumer100(user);
        if (i > 0) {
            flag = true;
        }

        return flag;
    }

    public Boolean refund20(User user) {
        boolean flag = false;
        Integer i = this.userMapper.refund20(user);
        if (i > 0) {
            flag = true;
        }

        return flag;
    }

    public List<UserDetails> Details(Integer uid) {
        return this.userMapper.Details(uid);
    }

    public void addDetails(Integer uid, String desc) {
        this.userMapper.addDetails(uid, desc);
    }
}
