package com.junction.natio.web.repository;


import com.junction.natio.core.repository.ICrudRepository;
import com.junction.natio.web.model.UserEntity;

import java.util.List;

/**

 */
public interface IUserRepository extends ICrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

}
