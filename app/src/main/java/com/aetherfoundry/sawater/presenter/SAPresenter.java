package com.aetherfoundry.sawater.presenter;

import com.aetherfoundry.sawater.api.Api;
import com.aetherfoundry.sawater.api.ApiWrapper;
import com.aetherfoundry.sawater.model.WaterLevelModel;
import com.aetherfoundry.sawater.view.MVPView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by EJ on 7/1/2015.
 */
public class SAPresenter implements MVPPresenter {

    private MVPView myView;
    private Api myApi;
    private WaterLevelModel currentWaterLevelModel;



    public SAPresenter()
    {
        myApi= new ApiWrapper();
    }
    @Override
    public void onResume() {

    }

    @Override
    public void onRefresh() {

           System.out.println("Got Mesage to Update from View");
           myApi.getApi().getLevel()
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
