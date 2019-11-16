package com.junction.natio.web.dto.requestDto;

import com.junction.natio.core.model.RequestDtoBase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRequestDto extends RequestDtoBase {
    private String name;
    private String email;
    private String password;

}
