package com.junction.natio.core.accessControl.responseDto;

import com.junction.natio.core.model.ResponseDtoBase;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 02/02/2019.
 */
@Getter
@Setter
public class UmRoleResponseDto extends ResponseDtoBase {
    Integer level;
    String description;
}
