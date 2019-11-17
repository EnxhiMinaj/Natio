package com.junction.natio.web.controller;

import com.junction.natio.core.constant.WebResourceConstant;
import com.junction.natio.core.controller.ControllerBase;
import com.junction.natio.core.model.ResponseObj;
import com.junction.natio.core.utils.IBeanMapper;
import com.junction.natio.core.utils.impl.BeanMapperImpl;
import com.junction.natio.web.dto.responseDto.ChartDataDto;
import com.junction.natio.web.enums.ChartPeriods;
import com.junction.natio.web.service.IRecommenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RecommenderController.BASE_URL)
public class RecommenderController {
    public static final String BASE_URL = WebResourceConstant.NATIO.RECOMMENDER;
    private IRecommenderService recommenderService;

    public RecommenderController(IRecommenderService recommenderService) {
        this.recommenderService = recommenderService;
    }

    @GetMapping(WebResourceConstant.NATIO.GET_CHART_DATA)
    public ResponseEntity<ResponseObj> getChartData(@RequestParam String period, @RequestParam(required=false) String hour, @RequestParam(required=false) String day) {
        int hourValue, dayValue = 0;
        hourValue = hour.isEmpty() ? 0 : Integer.parseInt(hour);
        dayValue = day.isEmpty() ? 0 : Integer.parseInt(hour);

        ChartDataDto result = recommenderService.getVisitorData(period, hourValue, dayValue);

        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().result(result).message("Success").build(), HttpStatus.OK);
    }


}
