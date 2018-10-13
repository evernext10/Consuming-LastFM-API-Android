package com.evertdev.lastfm.ui.toptrackslisting;

import com.evertdev.lastfm.models.TopTracksResponse;
import com.evertdev.lastfm.network.TopTracksService;

import io.reactivex.Single;
import retrofit2.Retrofit;

/**
 * Created by Evert Dev.
 */

public class TopTracksInteractorImpl implements TopTracksInteractor {
    Retrofit mRetrofit;

    public TopTracksInteractorImpl(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    @Override
    public Single<TopTracksResponse> getTopTracks(String userName, int limit, String apiKey) {
        return mRetrofit.create(TopTracksService.class).getTopTracks(userName, limit, apiKey);
    }
}
