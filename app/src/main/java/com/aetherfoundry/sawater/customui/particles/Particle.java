package com.aetherfoundry.sawater.customui.particles;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Vector;

/**
 * Created by EJ on 7/31/2015.
 */
public class Particle {
    public static final int DEAD=0;
    public static final int ALIVE=1;
    private int myState;
    private float myX,myY;
    private double myXvelocity, myYvelocity;
    private float myAge;
    private float myLifespan;
    private Paint myPaint;
    private float myRadius;
    private int[] myARGB;


    private double getRandom(double min, double max)
    {
        return min+(max-min)*Math.random();
    }

    public int getMyState(){
        return myState;
    }
    public Particle(float x, float y, int lifetime, double maxSpeed, int maxRaduis, int maxAlpha)
    {
        myState=ALIVE;
        myX=x;
        myY=y;
        myLifespan=(int)getRandom(0,lifetime);
        myXvelocity=getRandom(-maxSpeed,maxSpeed);
        myYvelocity=getRandom(-maxSpeed,maxSpeed);
        myRadius=(float)getRandom(0,maxRaduis);
        myARGB=new int[4];
        myARGB[0]=0xff;
        myARGB[1]=(int)getRandom(0,255);
        myARGB[2]=(int)getRandom(0,255);
        myARGB[3]=(int)getRandom(0,255);
        myAge=0;
        myPaint= new Paint();
        myPaint.setARGB(myARGB[0],myARGB[1],myARGB[2],myARGB[3]);
        myPaint.setFilterBitmap(true);
    }
    public void upDate(){
            if(myState!=DEAD){
                myX+=myXvelocity;
                myY+=myYvelocity;
                if(myAge>=myLifespan)
                    myState=DEAD;
                else {
                    myAge++;
                    myARGB[0] = (int) ( (myLifespan - myAge)/ (myLifespan) * 255);
                    myPaint.setAlpha(myARGB[0]);
                }

                if(myARGB[0]<=0||myX<0||myY<0)
                    myState=DEAD;

            }
    }
    public void draw(Canvas c){
        c.drawCircle(myX,myY,myRadius,myPaint);
        upDate();
    }

}
