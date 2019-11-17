package com.junction.natio.web.repository;


import com.junction.natio.core.repository.ICrudRepository;
import com.junction.natio.web.model.LocationEntity;

import java.util.List;

public interface ILocationRepository extends ICrudRepository<LocationEntity, Long> {

    List<LocationEntity> getByUserID(Long userId);
}
