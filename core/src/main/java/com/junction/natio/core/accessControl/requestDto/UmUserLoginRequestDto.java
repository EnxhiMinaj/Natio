package com.junction.natio.core.accessControl.requestDto;

import com.junction.natio.core.model.ModelBase;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 02/02/2019.
 */
@Getter
@Setter
public class UmUserLoginRequestDto extends ModelBase {
    private String userName;
    private String password;
}
