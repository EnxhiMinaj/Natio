package com.junction.natio.web.controller;

import com.junction.natio.core.constant.WebResourceConstant;
import com.junction.natio.core.exception.NatioException;
import com.junction.natio.core.model.ResponseObj;
import com.junction.natio.web.model.LocationEntity;
import com.junction.natio.web.service.ILocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(LocationController.BASE_URL)
public class LocationController {
    public static final String BASE_URL = WebResourceConstant.NATIO.LOCATION;
    private ILocationService locationService;

    public LocationController(ILocationService locationService) {

        this.locationService = locationService;
    }
    @GetMapping(WebResourceConstant.GET_ALL)
    public ResponseEntity<ResponseObj> getAll() {
        List<LocationEntity> entities = this.locationService.findAll();
        if (entities.size() == 0) {
            throw new NatioException("Sorry!! No Records Found");
        }
        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().result(entities).message("Success").build(), HttpStatus.OK);
    }

}
