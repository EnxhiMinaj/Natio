package com.junction.natio.web.controller;

import com.junction.natio.azure.service.PersonalizerService;
import com.junction.natio.core.constant.WebResourceConstant;
import com.junction.natio.core.controller.ControllerBase;
import com.junction.natio.core.model.ResponseObj;
import com.junction.natio.core.utils.IBeanMapper;
import com.junction.natio.core.utils.impl.BeanMapperImpl;
import com.junction.natio.web.dto.responseDto.ChartDataDto;
import com.junction.natio.web.enums.ChartPeriods;
import com.junction.natio.web.model.LocationEntity;
import com.junction.natio.web.model.VisitorData;
import com.junction.natio.web.service.ILocationService;
import com.junction.natio.web.service.IRecommenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RecommenderController.BASE_URL)
public class RecommenderController {
    public static final String BASE_URL = WebResourceConstant.NATIO.RECOMMENDER;
    private IRecommenderService recommenderService;
    private PersonalizerService personalizerService;
    private ILocationService locationService;

    public RecommenderController(IRecommenderService recommenderService, PersonalizerService personalizerService, ILocationService locationService) {
        this.recommenderService = recommenderService;
        this.personalizerService = personalizerService;
        this.locationService = locationService;
    }

    @GetMapping(WebResourceConstant.NATIO.GET_CHART_DATA)
    public ResponseEntity<ResponseObj> getChartData(@RequestParam String period) {
        ChartDataDto result = recommenderService.getVisitorData(period);

        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().result(result).message("Success").build(), HttpStatus.OK);
    }

    @GetMapping(WebResourceConstant.NATIO.GET_RECOMMENDED_PLACES)
    public ResponseEntity<ResponseObj> getRecommendedPlaces() {

        List<LocationEntity> listOfMyTrips = locationService.getByUserId(1l);
        List<String> myTrips = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        for (LocationEntity trip : listOfMyTrips) {
            myTrips.add(trip.getLat()+"|"+trip.getLng());
        }
        List<VisitorData> visitorList = recommenderService.getVisitorDataList();
        for (VisitorData visitor : visitorList) {
            if (actions.indexOf(visitor.getLat()+ "|"+visitor.getLng()) > 0 || actions.size() > 40) {

            } else {
                actions.add(visitor.getLat()+ "|"+visitor.getLng());
            }
        }
        List<String> result = personalizerService.runPersonalizer(actions, myTrips);

        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().result(result).message("Success").build(), HttpStatus.OK);
    }


}
