package com.junction.natio.web.service.impl;

import com.junction.natio.core.repository.ICrudRepository;
import com.junction.natio.core.service.ICrudService;
import com.junction.natio.core.service.impl.CrudServiceImpl;
import com.junction.natio.web.dto.responseDto.ChartDataDto;
import com.junction.natio.web.enums.ChartPeriods;
import com.junction.natio.web.model.VisitorData;
import com.junction.natio.web.service.IRecommenderService;
import com.junction.natio.web.util.IFileHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class RecommenderServiceImpl implements IRecommenderService {

    private List<VisitorData> visitorData;
    private IFileHelper fileHelper;

    public RecommenderServiceImpl(IFileHelper fileHelper) {
        this.fileHelper = fileHelper;
        this.getVisitorDataAPI();
    }
    @Override
    public ChartDataDto getVisitorData(String period, int hour, int day) {
        if (period.equalsIgnoreCase(ChartPeriods.DAILY.getChartPeriod())) {
            return this.getDailyVisitorsData(day);
        } else if (period.equalsIgnoreCase(ChartPeriods.HOURLY.getChartPeriod())) {
            return this.getHourlyVisitorsData(hour, day);
        } else {
            return this.getMonthlyVisitorsData();
        }
    }

    @Override
    public ChartDataDto getMonthlyVisitorsData() {
        return null;
    }

    @Override
    public ChartDataDto getHourlyVisitorsData(int hour, int day) {
       return null;
    }

    @Override
    public ChartDataDto getDailyVisitorsData(int dayOfWeek) {
       ChartDataDto dto = new ChartDataDto();
       dto.setPeriod("test");
       dto.setChartData(new HashMap<>());
       return dto;
    }

    public void getVisitorDataAPI() {
        /*try {
            fileHelper.getVisitorsData();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
