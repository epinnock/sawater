package com.aetherfoundry.sawater.di.module;

import android.app.Application;

import com.aetherfoundry.sawater.api.Api;
import com.aetherfoundry.sawater.api.ApiWrapper;
import com.aetherfoundry.sawater.presenter.MVPPresenter;
import com.aetherfoundry.sawater.presenter.SAPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by EJ on 7/9/2015.
 */


@Module
public final class ApiModule {
    @Provides @Singleton public Api provideApiWrapper()
    {
        return new ApiWrapper();
    }

    @Provides @Singleton public MVPPresenter provideSAPresenter()
    {
        return new SAPresenter();
    }

}
