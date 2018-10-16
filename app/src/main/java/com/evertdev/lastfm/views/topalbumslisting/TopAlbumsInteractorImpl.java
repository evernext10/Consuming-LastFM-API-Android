package com.evertdev.lastfm.views.topalbumslisting;

import com.evertdev.lastfm.models.TopAlbumsResponse;
import com.evertdev.lastfm.network.TopAlbumsService;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by Evert Dev.
 */

public class TopAlbumsInteractorImpl implements TopAlbumsInteractor {
    Retrofit mRetrofit;

    public TopAlbumsInteractorImpl(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    @Override
    public Single<TopAlbumsResponse> getTopAlbums(String userName, int limit, String apiKey) {
        return mRetrofit.create(TopAlbumsService.class).getTopArtists(userName, limit, apiKey);
    }
}
