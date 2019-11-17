package com.junction.natio.web.controller;


import com.junction.natio.core.constant.WebResourceConstant;
import com.junction.natio.core.controller.ControllerBase;
import com.junction.natio.core.exception.NatioException;
import com.junction.natio.core.model.ResponseObj;
import com.junction.natio.core.model.TokenModel;
import com.junction.natio.core.utils.TokenUtils;
import com.junction.natio.core.utils.impl.BeanMapperImpl;
import com.junction.natio.web.dto.requestDto.*;
import com.junction.natio.web.dto.responseDto.UserResponseDto;
import com.junction.natio.web.model.UserEntity;
import com.junction.natio.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Anil Kumal on 02/02/2019.
 */
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController extends ControllerBase {
    public static final String BASE_URL = WebResourceConstant.NATIO.USER;
    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        super(userService, new BeanMapperImpl(UserEntity.class, UserRequestDto.class), new BeanMapperImpl(UserEntity.class, UserResponseDto.class));
        this.userService = userService;
    }

    @PostMapping(WebResourceConstant.UserManagement.CHANGE_PASSWORD)
    public ResponseEntity<ResponseObj> changePassword(@RequestBody @Valid ChangePasswordRequestDto changePasswordRequestDto) {
        if (changePasswordRequestDto.getNewPassword().equals(changePasswordRequestDto.getConfirmPassword())) {
            TokenModel tokenModel = TokenUtils.getTokenModel();
            this.userService.changePassword(changePasswordRequestDto.getOldPassword(), changePasswordRequestDto.getNewPassword(), tokenModel.getUserId());
        } else {
            throw new NatioException("Confirmed Password Didn't match With New Password");
        }

        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().message("Password has been Changed Successfully.").build(), HttpStatus.OK);
    }
}
