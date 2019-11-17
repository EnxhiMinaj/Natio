package com.junction.natio.web.service;

import com.junction.natio.core.service.ICrudService;
import com.junction.natio.web.dto.responseDto.ChartDataDto;
import com.junction.natio.web.model.LocationEntity;

public interface IRecommenderService  {

    ChartDataDto getVisitorData(String period, int hour, int day);
    ChartDataDto getMonthlyVisitorsData();
    ChartDataDto getHourlyVisitorsData(int hour, int day);
    ChartDataDto getDailyVisitorsData(int dayOfWeek);
}
