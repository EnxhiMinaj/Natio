package com.junction.natio.web.service.impl;

import com.junction.natio.core.repository.ICrudRepository;
import com.junction.natio.core.service.ICrudService;
import com.junction.natio.core.service.impl.CrudServiceImpl;
import com.junction.natio.web.dto.responseDto.ChartDataDto;
import com.junction.natio.web.enums.ChartPeriods;
import com.junction.natio.web.model.LocationPoint;
import com.junction.natio.web.model.VisitorData;
import com.junction.natio.web.service.ICityNatureAPIService;
import com.junction.natio.web.service.IRecommenderService;
import com.junction.natio.web.util.IFileHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class RecommenderServiceImpl implements IRecommenderService {

    private ICityNatureAPIService cityNatureAPIService;
    private List<VisitorData> visitorDataList = new ArrayList<>();
    int sundayCount = 0;
    int mondayCount = 0;
    int tuesdayCount = 0;
    int wednesdayCount = 0;
    int thursdayCount = 0;
    int fridayCount = 0;
    int saturdayCount = 0;

    public RecommenderServiceImpl(ICityNatureAPIService cityNatureAPIService) {
        this.cityNatureAPIService = cityNatureAPIService;
        this.getVisitorDataAPI();
    }
    @Override
    public ChartDataDto getVisitorData(String period) {
        if (period.equalsIgnoreCase(ChartPeriods.DAILY.getChartPeriod())) {
            return this.getDailyVisitorsData();
        } else if (period.equalsIgnoreCase(ChartPeriods.HOURLY.getChartPeriod())) {
            return this.getHourlyVisitorsData();
        } else {
            return this.getMonthlyVisitorsData();
        }
    }

    @Override
    public ChartDataDto getMonthlyVisitorsData() {
        return null;
    }

    @Override
    public ChartDataDto getHourlyVisitorsData() {
       return null;
    }

    public ChartDataDto getDailyVisitorsData() {
        HashMap<String, Integer> dailyVisits = new HashMap<>();
        for(VisitorData visitorData : visitorDataList) {
            Calendar c = Calendar.getInstance();
            Date date = Date.from( visitorData.getStartTime().atZone(ZoneId.systemDefault()).toInstant());
            c.setTime(date);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

            switch (dayOfWeek)  {
                case 1:
                    if (dailyVisits.containsKey("Sunday")) {
                        dailyVisits.put("Sunday", dailyVisits.get("Sunday") + visitorData.getVisits());
                    } else {
                        dailyVisits.put("Sunday", visitorData.getVisits());
                    }
                    sundayCount++;
                    break;
                case 2:
                    if (dailyVisits.containsKey("Monday")) {
                        dailyVisits.put("Monday", dailyVisits.get("Monday") + visitorData.getVisits());
                    } else {
                        dailyVisits.put("Monday", visitorData.getVisits());
                    }
                    mondayCount++;
                    break;
                case 3:
                    if (dailyVisits.containsKey("Tuesday")) {
                        dailyVisits.put("Tuesday", dailyVisits.get("Tuesday") + visitorData.getVisits());
                    } else {
                        dailyVisits.put("Tuesday", visitorData.getVisits());
                    }
                    tuesdayCount++;
                    break;
                case 4:
                    if (dailyVisits.containsKey("Wednesday")) {
                        dailyVisits.put("Wednesday", dailyVisits.get("Wednesday") + visitorData.getVisits());
                    } else {
                        dailyVisits.put("Wednesday", visitorData.getVisits());
                    }
                    wednesdayCount++;
                    break;
                case 5:
                    if (dailyVisits.containsKey("Thursday")) {
                        dailyVisits.put("Thursday", dailyVisits.get("Thursday") + visitorData.getVisits());
                    } else {
                        dailyVisits.put("Thursday", visitorData.getVisits());
                    }
                    thursdayCount++;
                    break;
                case 6:
                    if (dailyVisits.containsKey("Friday")) {
                        dailyVisits.put("Friday", dailyVisits.get("Friday") + visitorData.getVisits());
                    } else {
                        dailyVisits.put("Friday", visitorData.getVisits());
                    }
                    fridayCount++;
                    break;
                case 7:
                    if (dailyVisits.containsKey("Saturday")) {
                        dailyVisits.put("Saturday", dailyVisits.get("Saturday") + visitorData.getVisits());
                    } else {
                        dailyVisits.put("Saturday", visitorData.getVisits());
                    }
                    saturdayCount++;
                    break;
                default:
                    break;

            }
        }
        dailyVisits = utilizeVisits(dailyVisits);
        ChartDataDto response = new ChartDataDto();
        response.setChartData(dailyVisits);
        return response;
    }

    @Override
    public List<VisitorData> getVisitorDataList() {
        return visitorDataList;
    }

    private HashMap<String, Integer> utilizeVisits(HashMap<String, Integer> dailyVisits) {
        if (dailyVisits.containsKey("Sunday")) {
            dailyVisits.put("Sunday", Math.round(dailyVisits.get("Sunday") / sundayCount));
        }
        if (dailyVisits.containsKey("Monday")) {
            dailyVisits.put("Monday", Math.round(dailyVisits.get("Monday") / mondayCount));
        }
        if (dailyVisits.containsKey("Tuesday")) {
            dailyVisits.put("Tuesday", Math.round(dailyVisits.get("Tuesday") / tuesdayCount));
        }
        if (dailyVisits.containsKey("Wednesday")) {
            dailyVisits.put("Wednesday", Math.round(dailyVisits.get("Wednesday") / wednesdayCount));
        }
        if (dailyVisits.containsKey("Thursday")) {
            dailyVisits.put("Thursday", Math.round(dailyVisits.get("Thursday") / thursdayCount));
        }
        if (dailyVisits.containsKey("Friday")) {
            dailyVisits.put("Friday", Math.round(dailyVisits.get("Friday") / fridayCount));
        }
        if (dailyVisits.containsKey("Saturday")) {
            dailyVisits.put("Saturday", Math.round(dailyVisits.get("Saturday") / saturdayCount));
        }
        return dailyVisits;

    }

    public void getVisitorDataAPI() {
        List<String> allNatureLocation = cityNatureAPIService.getAllNatureLocation();
        Random rand = new Random();
        int minDay = (int) LocalDate.of(2019, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2019, 11, 1).toEpochDay();
        long randomDay = minDay + rand.nextInt(maxDay - minDay);
        for (int i = 0; i < 3; i++) {
            if (allNatureLocation.size() > i && allNatureLocation.get(i) != null) {
                List<LocationPoint> locationPoints = cityNatureAPIService.getByNatureLocationName(allNatureLocation.get(i));
                for (LocationPoint point : locationPoints) {
                    randomDay = minDay + rand.nextInt(maxDay - minDay);
                    LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
                    VisitorData data = new VisitorData();
                    data.setLng(point.getLng());
                    data.setLat(point.getLat());
                    data.setVisits(rand.nextInt(95));
                    int startTime = rand.nextInt(20);
                    data.setStartTime(randomDate.atTime(startTime, 0));
                    data.setEndTime(randomDate.atTime((startTime + 1), 0));
                    data.setLocationName(point.getName());
                    visitorDataList.add(data);
                }
            }
        }
    }
}
