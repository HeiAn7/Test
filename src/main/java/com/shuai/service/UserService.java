package com.shuai.service;

import com.shuai.entity.User;
import com.shuai.entity.UserDetails;
import java.util.List;

public interface UserService {
    Double QueryBalance(Integer id);

    Boolean Consumer100(User user);

    Boolean refund20(User user);

    List<UserDetails> Details(Integer uid);

    void addDetails(Integer uid, String desc);
}
