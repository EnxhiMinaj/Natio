package com.junction.natio.web.service.impl;

import com.junction.natio.core.repository.ICrudRepository;
import com.junction.natio.core.service.impl.CrudServiceImpl;
import com.junction.natio.core.utils.DateUtils;
import com.junction.natio.web.dto.requestDto.LocationRequestDto;
import com.junction.natio.web.model.LocationEntity;
import com.junction.natio.web.model.LocationPoint;
import com.junction.natio.web.repository.ILocationRepository;
import com.junction.natio.web.service.ILocationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LocationServiceImpl extends CrudServiceImpl<LocationEntity, Long> implements ILocationService {

    private ILocationRepository locationRepository;

    public LocationServiceImpl(ILocationRepository locationRepository) {
        super(locationRepository);
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationEntity> getByUserId(Long userId) {
        return locationRepository.getByUserID(userId);
    }

    @Override
    public void saveTrips(LocationRequestDto dto) {
        for (LocationPoint point : dto.getLocationPointList()) {
            LocationEntity entity = new LocationEntity();
            entity.setName(point.getName());
            entity.setLng(point.getLng());
            entity.setLat(point.getLat());
            entity.setDate(new Date());
            entity.setStartTime(DateUtils.convertStringTimeIntoSqlTime(dto.getStartTime()));
            entity.setEndTime(DateUtils.convertStringTimeIntoSqlTime(dto.getEndTime()));
            locationRepository.save(entity);
        }
    }
}
