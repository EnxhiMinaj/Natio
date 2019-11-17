package com.junction.natio.web.dto.responseDto;

import com.junction.natio.core.model.ResponseDtoBase;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;


@Getter
@Setter
public class ChartDataDto extends ResponseDtoBase {
    private HashMap<String, Integer> chartData;
    private String period;
}
