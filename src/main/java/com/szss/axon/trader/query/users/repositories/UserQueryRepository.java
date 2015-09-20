package com.szss.axon.trader.query.users.repositories;

import com.szss.axon.trader.query.users.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by zcg on 15/9/18.
 */
public interface UserQueryRepository extends PagingAndSortingRepository<UserEntity, String> {

    public UserEntity findByUsername(String username);

}
