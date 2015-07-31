package com.aetherfoundry.sawater.customui;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by EJ on 7/25/2015.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer myRenderer;
    public MyGLSurfaceView(Context c)
    {
        super(c);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        myRenderer = new MyGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(myRenderer);
        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

}
