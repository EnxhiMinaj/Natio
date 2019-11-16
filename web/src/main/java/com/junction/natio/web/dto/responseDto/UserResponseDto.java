package com.junction.natio.web.dto.responseDto;

import com.junction.natio.core.model.ResponseDtoBase;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserResponseDto extends ResponseDtoBase {
    private String name;
    private String email;

}
