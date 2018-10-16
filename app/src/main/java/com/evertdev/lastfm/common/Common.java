package com.evertdev.lastfm.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Evert Dev.
 */

public class Common {
    public static final String API_KEY = "df21ef757e843e0e2d57fab479b69281";
    public static String BASE_URL = "http://ws.audioscrobbler.com/2.0/";
    public static final int TOP_ITEMS_LIMIT = 50;
    public static final String DEFAULT_LASTFM_USER = "drrobbins";

    private static final Common ourInstance = new Common();

    public static Common getInstance(){
        return ourInstance;
    }

    private Common(){

    }


    public static boolean NetworkStatus(Context context){
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;

        return connected;
    }
}
