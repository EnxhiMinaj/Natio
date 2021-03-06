package com.junction.natio.web.config;

import com.junction.natio.core.constant.WebResourceConstant;
import com.junction.natio.core.utils.StringUtils;
import com.junction.natio.core.utils.TokenUtils;
import com.junction.natio.web.util.INatioToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anil Kumal on 01/12/2018.
 */
public class AuthenticationHandlerInterceptor extends HandlerInterceptorAdapter {


    private static List<String> authorizationFreeuriList = new ArrayList<>();

    static {
        authorizationFreeuriList.add(WebResourceConstant.UserManagement.UM_AUTHENTICATE);
        authorizationFreeuriList.add(WebResourceConstant.UserManagement.SIGN_UP);
        authorizationFreeuriList.add("/user/create");
        authorizationFreeuriList.add("/upload");
        authorizationFreeuriList.add("/recommender");
        authorizationFreeuriList.add("/display");
        authorizationFreeuriList.add(WebResourceConstant.UserManagement.EMAIL);

    }

    @Autowired
    private INatioToken natioToken;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       /* //Do not delete the code
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return true;
        }
        return true;*/
        String uri = request.getRequestURI();
        String accessToken;
        //String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        System.out.println("request Uri = " + uri);
        if (isAuthFreeUri(uri)) {
            return true;
        }
        accessToken = request.getHeader(WebResourceConstant.AUTHORIZATION_HEADER);

        if (StringUtils.isNull(accessToken) && !isAuthFreeUri(uri)) {

            throw new Exception("Unauthorized access!!");
        }

        if (StringUtils.isNotNull(accessToken)) {
            TokenUtils.setTokenModel(natioToken.parseToken(accessToken));
            System.out.println("TokenUtils.getTokenModel() = " + TokenUtils.getTokenModel().toString());
        }


        return true;
    }

    private boolean isAuthFreeUri(String uri) {
        if (StringUtils.isNull(uri)) return false;
        for (String authFreeUri : authorizationFreeuriList) {
            if (uri.contains(authFreeUri)) {
                return true;
            }
        }
        return false;
    }


}
