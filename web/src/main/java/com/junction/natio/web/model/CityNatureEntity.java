package com.junction.natio.web.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CityNatureEntity {
    private String natureLocation;
    List<LocationPoint> locationPoints = new ArrayList<>();

}
