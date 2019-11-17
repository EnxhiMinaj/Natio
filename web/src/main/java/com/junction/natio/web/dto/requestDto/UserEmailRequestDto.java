package com.junction.natio.web.dto.requestDto;


import com.junction.natio.core.model.ModelBase;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Anil Kumal on 12/02/2018.
 */
@Getter
@Setter
public class UserEmailRequestDto extends ModelBase {
    private String email;
}
