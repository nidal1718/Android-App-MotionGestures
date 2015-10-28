/**
 * Created by nidalahammed on 23/10/2015.
 */
package com.example.nidalahammed.motiongesturesex2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.util.Log;


public class ConstainImageView extends ImageView {



    public static final String TAG ="VelocityTracker";

    public ConstainImageView(Context context) {
        super(context);
    }

    public ConstainImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ConstainImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ConstainImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setX(float x){
        View parent = (View)getParent();
        if(parent != null){
            int width = parent.getWidth();
            if(x < 0){
                Log.v(TAG, "OFF EDGE");
                super.setX(0);
                return;
            }
            if(x > width - getWidth()){
                Log.v(TAG, "OFF EDGE");
                super.setX(width - getWidth());
                return;
            }
        }
        super.setX(x);
    }

    @Override
    public void setY(float y){
        View parent = (View)getParent();
        if(parent != null){
            int height = parent.getHeight();
            if(y < 0){
                Log.v(TAG, "OFF EDGE");
                super.setY(0);
                return;
            }
            if(y > height - getHeight()){
                Log.v(TAG, "OFF EDGE");
                super.setY(height - getHeight());
                return;
            }
        }
        super.setY(y);
    }
}
