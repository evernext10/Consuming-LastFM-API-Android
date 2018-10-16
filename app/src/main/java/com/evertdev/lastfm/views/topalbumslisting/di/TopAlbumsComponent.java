package com.evertdev.lastfm.views.topalbumslisting.di;

import com.evertdev.lastfm.views.topalbumslisting.TopAlbumsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Evert Dev.
 */

@Singleton
@Component(modules = {TopAlbumsModule.class})
public interface TopAlbumsComponent {
    void inject(TopAlbumsFragment target);
}
