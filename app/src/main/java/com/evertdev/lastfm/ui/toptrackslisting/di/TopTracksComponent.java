package com.evertdev.lastfm.ui.toptrackslisting.di;

import com.evertdev.lastfm.ui.toptrackslisting.TopTracksFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Evert Dev.
 */
@Singleton
@Component(modules = {TopTracksModule.class})
public interface TopTracksComponent {
    void inject(TopTracksFragment target);
}
