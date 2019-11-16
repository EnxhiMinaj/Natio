package com.junction.natio.core.utils;

import com.junction.natio.core.model.TokenModel;
import org.springframework.stereotype.Component;

/**
 * Created by Anil Kumal on 02/02/2019.
 */
@Component
public class TokenUtils {

    private static TokenModel natioTokenModel;

    public static TokenModel getTokenModel() {
        return natioTokenModel;
    }

    public static void setTokenModel(final TokenModel natioTokenModel) {
        TokenUtils.natioTokenModel = natioTokenModel;
    }
}
