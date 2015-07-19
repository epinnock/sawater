package com.aetherfoundry.sawater.presenter;

import com.aetherfoundry.sawater.view.MVPView;

/**
 * Created by EJ on 7/1/2015.
 */
public interface MVPPresenter {

    void onResume();
    void onRefresh();
    void onStop();
    void injectView(MVPView mvpView);
}
