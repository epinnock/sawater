package com.aetherfoundry.sawater.model;

/**
 * Created by EJ on 7/2/2015.
 */

import com.google.gson.annotations.Expose;


public class Level {

    @Expose
    private double recent;
    @Expose
    private double average;
    @Expose
    private String lastUpdated;

    /**
     *
     * @return
     * Return the current water level reading
     */
    public double getRecent() {
        return recent;
    }

    public Level(double recent, double average, String lastUpdated)
    {
        this.recent=recent;
        this.average=average;
        this.lastUpdated=lastUpdated;
    }

    /**
     *
     * @param recent
     * Set the current water level reading using for testing
     */
    public void setRecent(double recent) {
        this.recent = recent;
    }

    /**
     *
     * @return
     * The 10 day average water level reading for the city
     */
    public double getAverage() {
        return average;
    }

    /**
     *
     * @param average
     * Set the 10 day average water level reading for the city used in testing
     */
    public void setAverage(double average) {
        this.average = average;
    }

    /**
     *
     * @return
     * The lastUpdated
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     *
     * @param lastUpdated
     * The lastUpdated
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}