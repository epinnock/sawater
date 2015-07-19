package com.aetherfoundry.sawater.model;



/**
 * Created by EJ on 7/1/2015.
 */

import javax.annotation.*;
import com.google.gson.annotations.Expose;


public class WaterLevelModel {

    @Expose
    private Level level;
    @Expose
    private long stageLevel;
    @Expose
    private boolean irrigationAllowed;

    public WaterLevelModel(Level level, long stageLevel, boolean irrigationAllowed){
        this.level=level;
        this.stageLevel=stageLevel;
        this.irrigationAllowed=irrigationAllowed;
    }

    /**
     *
     * @return
     * The level
     */

    public Level getLevel() {
        return level;
    }

    /**
     *
     * @param level
     * The water level object
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     *
     * @return
     * The stageLevel
     */
    public long getStageLevel() {
        return stageLevel;
    }

    /**
     *
     * @param stageLevel
     * The stageLevel
     */
    public void setStageLevel(long stageLevel) {
        this.stageLevel = stageLevel;
    }

    /**
     *
     * @return
     * The irrigationAllowed
     */
    public boolean isIrrigationAllowed() {
        return irrigationAllowed;
    }

    /**
     *
     * @param irrigationAllowed
     * The irrigationAllowed
     */
    public void setIrrigationAllowed(boolean irrigationAllowed) {
        this.irrigationAllowed = irrigationAllowed;
    }

}