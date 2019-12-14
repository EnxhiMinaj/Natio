package com.junction.natio.web.service;

import com.junction.natio.web.model.LocationPoint;

import java.util.List;

public interface ICityNatureAPIService {
    List<String> getAllNatureLocation();
    List<LocationPoint> getByNatureLocationName(String name);
    LocationPoint getByNatureLocationNameAndTrail(String place, String trail);
}
