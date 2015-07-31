package com.aetherfoundry.sawater.customui.particles;

import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by EJ on 7/31/2015.
 */
public class ParticleEngine {

    private ArrayList<Particle> myParticles;
    private short myState;
    private static final short ALIVE=1;
    private static final short DEAD=0;
    private int maxlife;
    private double maxSpeed;
    private int maxRadius;
    private float myParticlePropensity;
    private float myX, myY;

    public ParticleEngine(float particlePropensity, float x, float y,int lifetime, double maxSpeed, int maxRadius)
    {
        myParticlePropensity=particlePropensity;
        myX=x;
        myY=y;
        myState=ALIVE;
        myParticles=new ArrayList<Particle>();
        this.maxSpeed=maxSpeed;
        this.maxRadius=maxRadius;
        this.maxlife=lifetime;
    }

    public void generateParticles()
    {
            if(Math.random()<myParticlePropensity&&myParticles.size()<50)
                myParticles.add(new Particle(myX,myY,maxlife,maxSpeed,maxRadius,0xff));
            System.out.println(myParticles.size());
    }
    public void update(Canvas canvas)
    {
        generateParticles();
        for(int i=0;i<myParticles.size();i++){
            myParticles.get(i).draw(canvas);
            if(myParticles.get(i).getMyState()==DEAD)
                myParticles.remove(i);

        }

    }

}
