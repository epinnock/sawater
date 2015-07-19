package com.aetherfoundry.sawater;

import android.app.Application;
import android.content.res.Configuration;

import com.aetherfoundry.sawater.di.component.ApiComponent;
import com.aetherfoundry.sawater.di.component.DaggerApiComponent;
import com.aetherfoundry.sawater.di.module.ApiModule;
import com.aetherfoundry.sawater.presenter.MVPPresenter;
import com.aetherfoundry.sawater.presenter.SAPresenter;
import com.aetherfoundry.sawater.view.MVPView;
import javax.inject.Inject;
/**
 * Created by EJ on 7/2/2015.
 */
public class SAWaterApplication extends Application {

    private SAWaterApplication singleton;
    private MVPView myMVPView;
    @Inject
    MVPPresenter myMVPPresenter;
    private ApiComponent myComponent;
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public SAWaterApplication getSingleton()
    {
        return singleton;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        singleton=this;
        setupGraph();
        myComponent.inject(this);
        //connect();
    }

    public void setupGraph(){
        myComponent= DaggerApiComponent.builder()
                    .apiModule(new ApiModule())
                    .build();
    }
    public void setUpMockGraph(){

    }

    public void register(MVPView myMVPView){
            this.myMVPView=myMVPView;
            connect();

    }
    public void connect(){
        if(myMVPPresenter!=null&&myMVPView!=null) {
            this.myMVPPresenter.injectView(this.myMVPView);
            myMVPView.injectPresenter(myMVPPresenter);
        }
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
