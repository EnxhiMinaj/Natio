package com.junction.natio.web.dto.requestDto;

import com.junction.natio.core.model.ModelBase;
import com.junction.natio.web.model.LocationPoint;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class LocationRequestDto extends ModelBase {
    private Date date;
    private String startTime;
    private String endTime;
    private List<LocationPoint> locationPointList;
}
