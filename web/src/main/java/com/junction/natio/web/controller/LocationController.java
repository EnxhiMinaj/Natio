package com.junction.natio.web.controller;

import com.junction.natio.core.constant.WebResourceConstant;
import com.junction.natio.core.exception.NatioException;
import com.junction.natio.core.model.ResponseObj;
import com.junction.natio.core.utils.DateUtils;
import com.junction.natio.web.dto.requestDto.LocationRequestDto;
import com.junction.natio.web.model.LocationEntity;
import com.junction.natio.web.model.LocationPoint;
import com.junction.natio.web.service.ILocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(LocationController.BASE_URL)
public class LocationController {
    public static final String BASE_URL = WebResourceConstant.NATIO.LOCATION;
    private ILocationService locationService;

    public LocationController(ILocationService locationService) {

        this.locationService = locationService;
    }
    @GetMapping(WebResourceConstant.NATIO.MY_TRIPS)
    public ResponseEntity<ResponseObj> getMyTrips(@PathVariable Long userId) {
        List<LocationEntity> entities = this.locationService.getByUserId(userId);
        if (entities.size() == 0) {
            throw new NatioException("Sorry!! No Records Found");
        }
        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().result(entities).message("Success").build(), HttpStatus.OK);
    }

    @PostMapping(WebResourceConstant.NATIO.SAVE_LOCATION)
    public ResponseEntity<ResponseObj> saveTrips(@RequestBody @Valid LocationRequestDto dto) {
        locationService.saveTrips(dto);
        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().message("Records have been created.").build(), HttpStatus.OK);
    }



}
