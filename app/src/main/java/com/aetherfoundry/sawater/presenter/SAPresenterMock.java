package com.aetherfoundry.sawater.presenter;

/**
 * Created by EJ on 7/18/2015.
 */

import com.aetherfoundry.sawater.api.Api;
import com.aetherfoundry.sawater.model.*;
import com.aetherfoundry.sawater.api.ApiWrapper;
import com.aetherfoundry.sawater.view.MVPView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import com.aetherfoundry.sawater.api.Api;
import com.aetherfoundry.sawater.api.ApiWrapper;
import com.aetherfoundry.sawater.model.WaterLevelModel;
import com.aetherfoundry.sawater.view.MVPView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by EJ on 7/1/2015.
 */
public class SAPresenterMock implements MVPPresenter {

    private MVPView myView;
    private Api myApi;
    private WaterLevelModel currentWaterLevelModel;


    public SAPresenterMock(){
        currentWaterLevelModel= new WaterLevelModel(new Level(500.0,500.0,"mock time"),2,true);
    }

    public SAPresenterMock(WaterLevelModel curentWaterLevelModel) {
        this.currentWaterLevelModel=curentWaterLevelModel;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onRefresh() {

        System.out.println("Got Mesage to Update from View");
        Observable.just(currentWaterLevelModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((waterlevels)->{ if(myView!=null)
                            myView.update(waterlevels);}
                );


        //myView.update(currentWaterLevelModel);
    }

    @Override
    public void onStop() {

    }

    @Override
    public void injectView(MVPView myView)
    {
        this.myView=myView;
    }
}
