package com.evertdev.lastfm.views.topalbumslisting;

/**
 * Created by Evert Dev.
 */

public interface TopAlbumsPresenter {
    void onDestroy();
    void getTopAlbums(String userName,int limit,String apiKey);
}
