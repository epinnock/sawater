package com.aetherfoundry.sawater.api;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by EJ on 7/2/2015.
 */
public class ApiWrapper implements Api {
    private static final String API_BASE="http://sawaterlevels-api.herokuapp.com";
    private WaterLevelApi saApi;

    public ApiWrapper(){
        /*
        *
        * Replaced with Lambda
        *
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept","application/json");
            }
        };
        */
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_BASE)
                .setRequestInterceptor(ri->ri.addHeader("Accept","application/json"))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        saApi=restAdapter.create(WaterLevelApi.class);
    }

    /*
     * @return Returns the Retrofit WaterLevelApi
     */
    @Override
    public WaterLevelApi getApi(){
        return saApi;
    }
}
