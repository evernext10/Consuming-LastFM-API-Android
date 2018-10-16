package com.evertdev.lastfm.views.topartistslisting;

import com.evertdev.lastfm.models.TopArtistsResponse;
import com.evertdev.lastfm.network.TopArtistsService;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by Evert Dev.
 */

public class TopArtistsInteractorImpl implements TopArtistsInteractor {
    Retrofit mRetrofit;

    public TopArtistsInteractorImpl(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    @Override
    public Single<TopArtistsResponse> getTopArtists(String userName, int limit, String apiKey) {
        return mRetrofit.create(TopArtistsService.class).getTopArtists(userName, limit, apiKey);
    }
}
