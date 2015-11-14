package com.szss.axon.trader.service;

import com.szss.axon.trader.mapper.UserMapper;
import com.szss.axon.trader.query.users.UserEntity;
import com.szss.axon.trader.user.command.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zcg on 15/11/14.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void save(UserEntity user) {
        userMapper.save(user);
    }
}
