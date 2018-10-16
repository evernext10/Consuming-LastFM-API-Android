package com.evertdev.lastfm.views.toptrackslisting;

/**
 * Created by Evert Dev.
 */

public interface TopTracksPresenter  {
    void onDestroy();
    void getTopTracks(String userName,int limit,String apiKey);

}
