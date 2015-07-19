package com.aetherfoundry.sawater.di.component;

import android.app.Application;

import com.aetherfoundry.sawater.SAWaterApplication;
import com.aetherfoundry.sawater.api.Api;
import com.aetherfoundry.sawater.api.ApiWrapper;
import com.aetherfoundry.sawater.di.module.ApiModule;
import com.aetherfoundry.sawater.presenter.MVPPresenter;
import com.aetherfoundry.sawater.presenter.SAPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by EJ on 7/9/2015.
 */

@Singleton
@Component(modules=ApiModule.class)
public interface ApiComponent {
    void inject(SAWaterApplication app);
    Api provideApiWrapper();
    MVPPresenter providePresenter();
}
