package com.junction.natio.web.service;


import com.junction.natio.core.service.ICrudService;
import com.junction.natio.web.model.UserEntity;

import java.util.List;

/**
 * Created by Anil Kumal on 02/02/2019.
 */
public interface IUserService extends ICrudService<UserEntity, Long> {
    UserEntity authenticate(UserEntity userEntity);

    Boolean changePassword(String oldPassword, String newPassword, Long userId);


    UserEntity findByEmail(String email);
}
