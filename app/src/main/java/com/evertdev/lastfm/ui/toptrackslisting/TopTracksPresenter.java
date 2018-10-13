package com.evertdev.lastfm.ui.toptrackslisting;

/**
 * Created by Evert Dev.
 */

public interface TopTracksPresenter  {
    void onDestroy();
    void getTopTracks(String userName,int limit,String apiKey);

}
