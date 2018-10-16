package com.evertdev.lastfm.views.topartistslisting.di;

import com.evertdev.lastfm.views.topartistslisting.TopArtistsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Evert Dev.
 */

@Singleton
@Component(modules = {TopArtistsModule.class})
public interface TopArtistsComponent {
    void inject(TopArtistsFragment target);
}
