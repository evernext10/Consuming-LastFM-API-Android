package com.evertdev.lastfm.ui.topalbumslisting.di;

import com.evertdev.lastfm.ui.topalbumslisting.TopAlbumsFragment;

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
