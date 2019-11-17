package com.junction.natio.core.constant;

/**
 * Created by Anil Kumal on 03/02/2019.
 */
public class WebResourceConstant {


    /**
     * Common api end points
     */
    public static final String BASE_API = "/api";
    public static final String CREATE = "/create";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/{id}";
    public static final String GET_ALL = "/list";
    public static final String GET_ALL_WITH_PAGE = "/list/{currentPage}/{pageSize}";
    public static final String GET = "/{id}";

    //For file
    public static final String FILE = "/file";

    public static final String DISPLAY_FILE = "/display/{type}/{fileName}";
    public static final String FILE_DOWNLOAD = "/download";
    public static final String SEARCH = "/search/{currentPage}/{pageSize}";
    public static final String UPLOAD = "/upload";


    public static final String LOGGER = "/logger/{status}";
    //header Constants
    public static final String FORM_HEADER = "form";
    public static final String APPLICATION_HEADER = "application";
    public static final String AUTHORIZATION_HEADER = "authorization";
    public static final String IP = "ip";
    public static final String COUNTRY = "country";
    public static final String LAT = "lat";
    public static final String LON = "lon";

    /**
     * Module wise interface for api end points
     */
    public interface UserManagement {
        String UM_AUTHENTICATE = "/auth";
        String CHANGE_PASSWORD = "/chhangepassword";
        String EMAIL = "/email";
        String SIGN_UP = "/sign-up";


    }

    public interface NATIO {
        String NATIO_BASE = BASE_API + "/natio";
        String USER = NATIO_BASE + "/user";
        String LOCATION = NATIO_BASE + "/location";
        String MY_TRIPS = "/{userId}/trips";
        String RECOMMENDER = NATIO_BASE + "/recommender";
        String GET_CHART_DATA = "/data";
        String NATIO_NATURE_LOCATIONS = NATIO_BASE + "/nature-locations";
        String NATIO_NATURE_LOCATIONS_GET_ALL = "/get-all";
        String NATIO_NATURE_LOCATIONS_POINTS = "/get-location-point/{natureLocation}";
        String GET_RECOMMENDED_PLACES = "/get-recommended-places";
        String SAVE_LOCATION = "/save-trips";

    }

}
