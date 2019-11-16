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
    private Integer age;
    private String skill;
    private Boolean isAdmin;
    private String walletId;
    private Boolean status;
    private Double balanceCredits;

}
