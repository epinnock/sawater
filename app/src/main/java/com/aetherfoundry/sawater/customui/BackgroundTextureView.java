package com.aetherfoundry.sawater.customui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;

import com.aetherfoundry.sawater.customui.particles.Particle;
import com.aetherfoundry.sawater.customui.particles.ParticleEngine;

import java.util.jar.Attributes;


/**
 * Created by EJ on 7/26/2015.
 * Taken from tutorials found at:
 * https://software.intel.com/en-us/android/articles/2d-animation-for-android-seriescomparing-and-contrasting-different-ways-of-doing-the-same#02_textureview
 * Romain Guy http://pastebin.com/J4uDgrZ8
 *
 */
public class BackgroundTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private RenderingThread myRenderer;
    ParticleEngine myParticleEngine;

    public BackgroundTextureView(Context c){
        super(c);
        setSurfaceTextureListener(this);
        setOpaque(true);
    }
    public BackgroundTextureView(Context context , AttributeSet attrs){
        super(context, attrs);
        setSurfaceTextureListener(this);
        setOpaque(false);
        myParticleEngine=new ParticleEngine(.8f,600,800,300,60,50);
    }

    public void kickstart()
    {
        myRenderer= new RenderingThread(this);
        myRenderer.start();
        System.out.println("kickstarting");
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        System.out.println("Calling onSurfaceTextureAvailable entry ");
        myRenderer= new RenderingThread(this);
        myRenderer.start();
        System.out.println("Calling onSurfaceTextureAvailable");
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {

        if (myRenderer!=null)
            myRenderer.stopRendering();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    private class RenderingThread extends Thread{
        private BackgroundTextureView myBTV;
        private boolean isRunning=true;
        long currentTime;
        long oldTime;
        double fps;
        public RenderingThread(BackgroundTextureView myBTV){
            this.myBTV=myBTV;
        }

        public void run(){


            Paint paint = new Paint();
            paint.setColor(0xff00ff00);
            paint.setTextSize(52.0f);

            while(isRunning&&!Thread.interrupted()){
                final Canvas canvas = myBTV.lockCanvas();
                try {
                      currentTime=System.currentTimeMillis();
                      if(oldTime!=0){
                          fps=1000.0/(double)(currentTime-oldTime);
                      }
                      oldTime=currentTime;
                    //canvas.drawColor(0x00000000, PorterDuff.Mode.CLEAR);
                    canvas.drawColor(Color.WHITE);
                    canvas.drawText(fps + " fps", 50, 200, paint);
                    myParticleEngine.update(canvas);


                } finally {
                    myBTV.unlockCanvasAndPost(canvas);
                }



                try {
                    Thread.sleep(14);
                } catch (InterruptedException e) {
                    // Interrupted
                }
            }
        }
        public void stopRendering(){
            interrupt();
            isRunning=false;
        }

    }
}
