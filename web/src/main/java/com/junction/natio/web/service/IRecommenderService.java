package com.junction.natio.web.service;

import com.junction.natio.core.service.ICrudService;
import com.junction.natio.web.dto.responseDto.ChartDataDto;
import com.junction.natio.web.model.LocationEntity;
import com.junction.natio.web.model.VisitorData;

import java.util.List;

public interface IRecommenderService  {

    ChartDataDto getVisitorData(String period);
    ChartDataDto getMonthlyVisitorsData();
    ChartDataDto getHourlyVisitorsData();
    ChartDataDto getDailyVisitorsData();
    List<VisitorData> getVisitorDataList();
}
