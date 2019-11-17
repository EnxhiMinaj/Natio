package com.junction.natio.web.service.impl;


import com.junction.natio.core.exception.NatioException;
import com.junction.natio.core.security.ImatraEncoder;
import com.junction.natio.core.service.impl.CrudServiceImpl;
import com.junction.natio.core.utils.SecurityUtils;
import com.junction.natio.web.model.UserEntity;
import com.junction.natio.web.repository.IUserRepository;
import com.junction.natio.web.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**

 */
@Transactional
@Service
public class UserServiceImpl extends CrudServiceImpl<UserEntity, Long> implements IUserService {

    private IUserRepository userRepository;
    private ImatraEncoder imatraEncoder;

    public UserServiceImpl(IUserRepository userRepository, ImatraEncoder imatraEncoder) {
        super(userRepository);
        this.userRepository = userRepository;
        this.imatraEncoder = imatraEncoder;
    }

    @Override
    public UserEntity authenticate(UserEntity userEntity) {
        System.out.println("encoded password: " + imatraEncoder.encrypt("admin"));
        UserEntity userToAuthenticate = this.userRepository.findByEmail(userEntity.getEmail());
        if (userToAuthenticate != null) {
            if (this.imatraEncoder.match(userEntity.getPassword(), userToAuthenticate.getPassword())) {
                return userToAuthenticate;
            }
        }
        return null;
    }


    @Override
    public Boolean changePassword(String oldPassword, String newPassword, Long userId) {

        UserEntity umUserEntity = userRepository.findOne(userId);
        if (imatraEncoder.match(oldPassword, umUserEntity.getPassword())) {
            umUserEntity.setPassword(imatraEncoder.encrypt(newPassword));
            userRepository.update(umUserEntity);
            return true;
        }
        throw new NatioException("Old Password Didn't match.");
    }

    @Override
    public UserEntity findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }


}
