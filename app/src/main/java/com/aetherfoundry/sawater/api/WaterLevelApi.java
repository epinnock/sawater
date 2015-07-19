package com.aetherfoundry.sawater.api;



import com.aetherfoundry.sawater.model.WaterLevelModel;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by EJ on 7/1/2015.
 */
public interface WaterLevelApi {

    @GET("/level")
    Observable<WaterLevelModel>getLevel();
}
