package news.agoda.com.technewssample.utils;

import news.agoda.com.technewssample.BuildConfig;

/**
 * Created by aabid-personal on 3/10/16.
 */
public class AppConstants {

    public static final long SPLASH_SCREEN_DELAY = 2500;
    private static String BASE_URL = "";
    private static String BASE_URL_DEBUG = "";

    public static String getBaseUrl() {
        if (BuildConfig.DEBUG) {
            //return staging url
            return BASE_URL_DEBUG;
        } else {
            //return LIVE/Prod url
            return BASE_URL;
        }
    }

}
