package com.junction.natio.web.repository.impl;


import com.junction.natio.core.repository.impl.CrudRepositoryImpl;
import com.junction.natio.web.model.QUserEntity;
import com.junction.natio.web.model.UserEntity;
import com.junction.natio.web.repository.IUserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**

 */
@Repository
public class UserRepositoryImpl extends CrudRepositoryImpl<UserEntity, Long> implements IUserRepository {
    public UserRepositoryImpl() {
        super(UserEntity.class);
    }

    @Override
    public UserEntity findByEmail(String email) {
        QUserEntity qUserEntity = QUserEntity.userEntity;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        UserEntity userEntity = jpaQueryFactory
                .selectFrom(qUserEntity)
                .where(qUserEntity.email.toLowerCase().eq(email.toLowerCase()))
                .fetchOne();
        return userEntity;
    }


}
