package com.junction.natio.core.accessControl.requestDto;

import com.junction.natio.core.model.ModelBase;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by admin on 02/02/2019.
 */
@Getter
@Setter
public class UmChangePasswordRequestDto extends ModelBase {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
