package com.junction.natio.web.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.junction.natio.core.utils.JsonUtil;
import com.junction.natio.web.model.CityNatureEntity;
import com.junction.natio.web.model.LocationPoint;
import com.junction.natio.web.service.ICityNatureAPIService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CityNatureAPIServiceImpl implements ICityNatureAPIService {
    private RestTemplate restTemplate;
    private List<CityNatureEntity> cityNatureEntities;

    public CityNatureAPIServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.cityNatureEntities = this.fetchFromAPI();
    }


    @Override
    public List<String> getAllNatureLocation() {
        List<String> natureLocationList = new ArrayList<>();
        this.cityNatureEntities.stream().forEach((cityNatureEntity) -> natureLocationList.add(cityNatureEntity.getNatureLocation()));
        return natureLocationList;
    }

    @Override
    public List<LocationPoint> getByNatureLocationName(String name) {
        for (CityNatureEntity cityNatureEntity: this.cityNatureEntities) {
            if(cityNatureEntity.getNatureLocation().equalsIgnoreCase(name)){
                return cityNatureEntity.getLocationPoints();
            }
        }
        return null;
    }

    private List<CityNatureEntity> fetchFromAPI(){
        List<CityNatureEntity> cityNatureEntities = new ArrayList<>();

        ResponseEntity<String> response = this.restTemplate.getForEntity("https://citynature.eu/api/wp/v2/places?cityid=4661", String.class);
        JsonNode cityData = JsonUtil.getJsonObjectFromString(response.getBody());
        if(cityData.isArray()) {
            Iterator<JsonNode> rootNode = cityData.elements();
            while (rootNode.hasNext()) {
                CityNatureEntity cityNatureEntity = new CityNatureEntity();
                JsonNode natureNode = rootNode.next();
                cityNatureEntity.setNatureLocation(natureNode.path("title").asText());
                JsonNode pointsNodeArr = natureNode.path("points");
                List<LocationPoint> locationPoints = new ArrayList<>();
                if (pointsNodeArr.isArray()) {
                    LocationPoint locationPointEntity = new LocationPoint();
                    Iterator<JsonNode> pointNodeItr = pointsNodeArr.elements();
                    while(pointNodeItr.hasNext()){
                        JsonNode pointsNode = pointNodeItr.next();
                        JsonNode locationPoint = pointsNode.path("locationPoint");
                        locationPointEntity.setLat(locationPoint.path("lat").asText());
                        locationPointEntity.setLng(locationPoint.path("lng").asText());
                        locationPointEntity.setPointInfo(locationPoint.path("pointInfo").asText());
                        locationPoints.add(locationPointEntity);
                    }
                }
                cityNatureEntity.setLocationPoints(locationPoints);
                cityNatureEntities.add(cityNatureEntity);
            }

        }
        return cityNatureEntities;
    }
}
