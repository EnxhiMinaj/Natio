package com.junction.natio.web.controller;

import com.junction.natio.core.constant.WebResourceConstant;
import com.junction.natio.core.exception.NatioException;
import com.junction.natio.core.model.ResponseObj;
import com.junction.natio.web.model.LocationPoint;
import com.junction.natio.web.service.ICityNatureAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(NatureLocationController.BASE_URL)
public class NatureLocationController {
    public static final String BASE_URL = WebResourceConstant.NATIO.NATIO_NATURE_LOCATIONS;
    private ICityNatureAPIService cityNatureAPIService;
    @Autowired
    public NatureLocationController(ICityNatureAPIService cityNatureAPIService) {
        this.cityNatureAPIService = cityNatureAPIService;
    }

    @GetMapping(WebResourceConstant.NATIO.NATIO_NATURE_LOCATIONS_GET_ALL)
    public ResponseEntity<ResponseObj> getAllNatureLocations() {
        List<String> entities = cityNatureAPIService.getAllNatureLocation();
        if (entities.size() == 0) {
            throw new NatioException("Sorry!! No Records Found");
        }
        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().result(entities).message("Success").build(), HttpStatus.OK);
    }

    @GetMapping(WebResourceConstant.NATIO.NATIO_NATURE_LOCATIONS_POINTS)
    public ResponseEntity<ResponseObj> getAllNatureLocations(@PathVariable String natureLocation) {
        List<LocationPoint> entities = cityNatureAPIService.getByNatureLocationName(natureLocation);
        if (entities.size() == 0) {
            throw new NatioException("Sorry!! No Records Found");
        }
        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().result(entities).message("Success").build(), HttpStatus.OK);
    }
}
