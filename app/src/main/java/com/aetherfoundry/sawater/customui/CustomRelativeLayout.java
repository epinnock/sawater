package com.aetherfoundry.sawater.customui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by EJ on 7/25/2015.
 */
public class CustomRelativeLayout extends RelativeLayout {
    BackgroundTextureView specialView;
    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        specialView=new BackgroundTextureView(context,attrs);
        this.addView(specialView);
        //specialView.kickstart();
    }
}
