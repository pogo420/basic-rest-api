package com.movie.info.service.dao;

import com.movie.info.service.bean.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserInfo, String> {
    ;
}
