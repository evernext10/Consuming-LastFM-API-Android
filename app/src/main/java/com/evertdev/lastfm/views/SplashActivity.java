package com.evertdev.lastfm.views;

import android.content.Intent;
import android.view.WindowManager;

import com.evertdev.lastfm.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {
    @Override
    public void initSplash(ConfigSplash configSplash) {
        getWindow().setFlags(WindowManager.LayoutParams.ROTATION_ANIMATION_CROSSFADE, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Background
        configSplash.setBackgroundColor(R.color.red);
        configSplash.setAnimCircularRevealDuration(500);

        //Logo
        configSplash.setLogoSplash(R.drawable.lastfm);
        configSplash.setAnimLogoSplashDuration(500);
        //configSplash.setAnimLogoSplashTechnique(Techniques.FadeInDown);
        configSplash.setTitleSplash("");

    }

    @Override
    public void animationsFinished() {
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        finish();

    }
}
