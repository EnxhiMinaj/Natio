package com.junction.natio.web.service.impl;


import com.junction.natio.core.exception.EmoneyException;
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
 * Created by Anil Kumal on 02/02/2019.
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
    public UserEntity save(UserEntity entity) {
        String encodedPassword = imatraEncoder.encrypt(entity.getPassword());
        entity.setPassword(encodedPassword);
        if(entity.getIsAdmin() == null) {
            entity.setIsAdmin(false);
        }
        entity.setStatus(true);
        entity.setBalanceCredits(1000.00);
        entity.setReserveCredits(0.00);
        entity.setWalletId(SecurityUtils.generateRandomString(4, 8).toUpperCase());
        return super.save(entity);
    }

    @Override
    public UserEntity authenticate(UserEntity userEntity) {
        System.out.println("encoded password: " + imatraEncoder.encrypt("admin"));
        UserEntity userToAuthenticate = this.userRepository.findByEmail(userEntity.getEmail());
        if (userToAuthenticate != null) {
            if (this.imatraEncoder.match(userEntity.getPassword(), userToAuthenticate.getPassword())) {
                if (!userToAuthenticate.getStatus())
                    throw new EmoneyException("User has been deactivated. Please contact your administrator.");
                return userToAuthenticate;
            }
        }
        return null;
    }

    @Override
    public Boolean changeStatus(Long id) {
        return this.userRepository.changeStatus(id);
    }

    @Override
    public Boolean addCredits(Long userId, Double credits) {
        UserEntity user = this.userRepository.findOne(userId);
        user.setBalanceCredits(user.getBalanceCredits()+credits);
        super.update(user);
        return true;
    }

    @Override
    public List<UserEntity> getAppUsers() {
       return this.userRepository.getAppUsers();
    }

    @Override
    public Boolean changePassword(String oldPassword, String newPassword, Long userId) {

        UserEntity umUserEntity = userRepository.findOne(userId);
        if (imatraEncoder.match(oldPassword, umUserEntity.getPassword())) {
            umUserEntity.setPassword(imatraEncoder.encrypt(newPassword));
            userRepository.update(umUserEntity);
            return true;
        }
        throw new EmoneyException("Old Password Didn't match.");
    }



    @Override
    public UserEntity findByWalletId(String walletId) {
        return this.userRepository.findByWalletId(walletId);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }


}
