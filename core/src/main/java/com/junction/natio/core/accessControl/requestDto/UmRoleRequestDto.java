package com.junction.natio.core.accessControl.requestDto;


import com.junction.natio.core.model.RequestDtoBase;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Anil Kumal on 02/02/2019.
 */
@Getter
@Setter
public class UmRoleRequestDto extends RequestDtoBase {
    Integer level;
    String description;
}
