package com.aetherfoundry.sawater.view;

import com.aetherfoundry.sawater.model.WaterLevelModel;
import com.aetherfoundry.sawater.presenter.MVPPresenter;

/**
 * Created by EJ on 7/1/2015.
 */
public interface MVPView {

    void update(WaterLevelModel wm);
    void progressBarUpdate(boolean b);
    void injectPresenter(MVPPresenter myPresenter);
}
