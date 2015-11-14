package com.szss.axon.trader.mapper;

import com.szss.axon.trader.api.users.UserCreatedEvent;
import com.szss.axon.trader.query.users.UserEntity;
import com.szss.commons.orm.mybatis.annotation.MybatisMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zcg on 15/11/14.
 */
@MybatisMapper
public interface UserMapper {
    public void save(@Param(value = "user")UserEntity user);
}
