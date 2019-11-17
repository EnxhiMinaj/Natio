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
import com.junction.natio.web.service.IUserService;
import com.junction.natio.web.util.INatioToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController extends ControllerBase {
    public static final String BASE_URL = WebResourceConstant.NATIO.USER;
    private IUserService userService;
    private INatioToken emoneyToken;

    @Autowired
    public UserController(IUserService userService, INatioToken emoneyToken) {
        super(userService, new BeanMapperImpl(UserEntity.class, UserRequestDto.class), new BeanMapperImpl(UserEntity.class, UserResponseDto.class));
        this.userService = userService;
        this.emoneyToken = emoneyToken;
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

    @PostMapping(WebResourceConstant.UserManagement.UM_AUTHENTICATE)
    public ResponseEntity<ResponseObj> authenticateUser(@RequestBody @Valid UserLoginRequestDto userLoginRequestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userLoginRequestDto.getEmail());
        userEntity.setPassword(userLoginRequestDto.getPassword());
        UserEntity authenticUser = this.userService.authenticate(userEntity);

        if (authenticUser == null) {
            throw new NatioException("Sorry!! Your email address or  password doesn't match");
        }


        String token = emoneyToken.generateToken(authenticUser);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("token", token);
        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().result(responseMap).build(), HttpStatus.OK);
    }

    @PostMapping(WebResourceConstant.UserManagement.SIGN_UP)
    public ResponseEntity<ResponseObj> changePassword(@RequestBody @Valid UserRequestDto userRequestDto) {
        UserEntity userEntity = (UserEntity) reqBeanMapper.mapToEntity(userRequestDto);
        userService.save(userEntity);
        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().message("Your account has been created. Please go to login page to sign in.").build(), HttpStatus.OK);
    }

    @PostMapping(WebResourceConstant.UserManagement.EMAIL)
    public ResponseEntity<ResponseObj> verifyUserByEmail(@RequestBody @Valid UserEmailRequestDto userEmailRequestDto) {
        UserEntity userEntity = this.userService.findByEmail(userEmailRequestDto.getEmail());

        return new ResponseEntity<>(new ResponseObj.ResponseObjBuilder().result(userEntity != null).build(), HttpStatus.OK);
    }

}
