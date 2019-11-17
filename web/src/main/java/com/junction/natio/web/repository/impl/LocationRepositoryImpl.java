package com.junction.natio.web.repository.impl;


import com.junction.natio.core.repository.impl.CrudRepositoryImpl;
import com.junction.natio.web.model.LocationEntity;
import com.junction.natio.web.repository.ILocationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepositoryImpl extends CrudRepositoryImpl<LocationEntity, Long> implements ILocationRepository {
    public LocationRepositoryImpl() {
        super(LocationEntity.class);
    }

}
