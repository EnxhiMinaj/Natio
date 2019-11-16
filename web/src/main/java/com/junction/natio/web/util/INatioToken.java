package com.junction.natio.web.util;


import com.junction.natio.core.model.TokenModel;
import com.junction.natio.web.model.UserEntity;

/**
 * Created by Anil Kumal on 01/12/2018.
 */
public interface INatioToken {
    /**
     * This method is used to generate token
     *
     * @param userEntity which contain system user information
     * @return token
     */
    String generateToken(UserEntity userEntity);

    /**
     * This method  is used to parse token
     *
     * @param token
     * @return TokenModel object
     */
    TokenModel parseToken(final String token);
}
