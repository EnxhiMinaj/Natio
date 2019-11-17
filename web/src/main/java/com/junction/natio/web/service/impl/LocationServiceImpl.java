package com.junction.natio.web.service.impl;

import com.junction.natio.core.repository.ICrudRepository;
import com.junction.natio.core.service.impl.CrudServiceImpl;
import com.junction.natio.web.model.LocationEntity;
import com.junction.natio.web.service.ILocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl extends CrudServiceImpl<LocationEntity, Long> implements ILocationService {

    public LocationServiceImpl(ICrudRepository<LocationEntity, Long> crudRepository) {
        super(crudRepository);
    }
}
