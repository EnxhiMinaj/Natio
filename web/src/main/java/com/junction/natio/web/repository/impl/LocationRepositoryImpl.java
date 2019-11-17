package com.junction.natio.web.repository.impl;


import com.junction.natio.core.repository.impl.CrudRepositoryImpl;
import com.junction.natio.web.model.LocationEntity;
import com.junction.natio.web.model.QLocationEntity;
import com.junction.natio.web.repository.ILocationRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationRepositoryImpl extends CrudRepositoryImpl<LocationEntity, Long> implements ILocationRepository {
    public LocationRepositoryImpl() {
        super(LocationEntity.class);
    }

    @Override
    public List<LocationEntity> getByUserID(Long userId) {
        QLocationEntity qLocationEntity = QLocationEntity.locationEntity;
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        List<LocationEntity> results = jpaQueryFactory
                .selectFrom(qLocationEntity)
                .where(qLocationEntity.userId.id.eq(userId))
                .fetch();
        return results;
    }
}
