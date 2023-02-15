package com.shuai.mapper;

import com.shuai.entity.User;
import com.shuai.entity.UserDetails;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Double QueryBalance(Integer id);

    Integer Consumer100(User user);

    Integer refund20(User user);

    List<UserDetails> Details(Integer uid);

    void addDetails(Integer id, String desc);
}

