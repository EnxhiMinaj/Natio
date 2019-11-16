package com.junction.natio.core.utils;

import com.junction.natio.core.model.TokenModel;
import org.springframework.stereotype.Component;

/**
 * Created by Anil Kumal on 02/02/2019.
 */
@Component
public class TokenUtils {

    private static TokenModel emoneyTokenModel;

    public static TokenModel getTokenModel() {
        return emoneyTokenModel;
    }

    public static void setTokenModel(final TokenModel emoneyTokenModel) {
        TokenUtils.emoneyTokenModel = emoneyTokenModel;
    }
}
