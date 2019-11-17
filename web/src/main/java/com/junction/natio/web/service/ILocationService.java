package com.junction.natio.web.service;


import com.junction.natio.core.service.ICrudService;
import com.junction.natio.web.dto.requestDto.LocationRequestDto;
import com.junction.natio.web.model.LocationEntity;

import java.util.List;

/**

 */
public interface ILocationService extends ICrudService<LocationEntity, Long> {

    List<LocationEntity> getByUserId(Long userId);

    void saveTrips(LocationRequestDto dto);

}
