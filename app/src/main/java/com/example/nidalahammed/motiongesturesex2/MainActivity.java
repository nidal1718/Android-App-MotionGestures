package com.example.nidalahammed.motiongesturesex2;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;



public class MainActivity extends Activity implements
        GestureDetector.OnGestureListener {

    public static final String TAG ="VelocityTracker";
    float x, y;
    int Dwidth, Dheight, Dwidth1, Dheight1  ;
    Display display ;
    private GestureDetectorCompat mDetector;
    private Drawable drawable1 ;
    private ImageView ball ;
    private ImageView myView;
    private Drawable[] drawables = null ;



    // screen size

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this,this);

        ball = (ImageView) findViewById(R.id.imageview);

        display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Dwidth = size.x;
        Dheight = size.y;


        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(1,1);
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.width = ViewGroup.LayoutParams.WRAP_CONTENT;


        drawables = new Drawable[] {
                getResources().getDrawable(R.drawable.football1)

                // obtain screen width and height

        };

        drawable1 = drawables[0];
        ball.setImageDrawable(drawable1);
        x = -1 ;
        y = -1 ;

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {


        if ( event.getAction() == MotionEvent.ACTION_MOVE) {
            ball.setX(event.getRawX() - ball.getWidth()/2);
            ball.setY(event.getRawY() - ball.getHeight()/2);
        }
        this.mDetector.onTouchEvent(event);

        return super.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent arg0) {
        // TODO Auto-generated method stub
        ball.setX(arg0.getRawX() - ball.getWidth()/2);
        ball.setY(arg0.getRawY() - ball.getHeight()/2);

        Log.v(TAG, "onDown");

        return true;
    }


//    private float calcFinalLoc(float coord, float dimension, float rawvalues)
//    {
//        float ret =0 ;
//        if(coord<0)
//        {
//            ret= 0;
//
//        }
////        //     boundaryX = calcFinalLoc(e2.getRawX(),Dwidth-ball.getWidth());
////        else if (coord <= dimension)
////        {
////            ret=   rawvalues;
////
////        }
//
//        else if (coord > dimension)
//        {
//            ret= dimension;
//
//        }
//        else
//        {
//            ret = -ret ;
//        }
//        return ret ;
//    }



    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {


        float oldX = e1.getRawX();
        float oldY = e1.getRawY();

        float newX = e2.getRawX() - ball.getWidth()/2;
        float newY = e2.getRawY() - ball.getHeight()/2;


        float diffX =  newX + velocityX*0.5f ;
        float diffY = newY+ velocityY*0.5f ;


        float velocityTotal = diffX*diffY;

        float diffX2 =  Dheight - diffX  ;
        float diffY2 =  Dwidth - diffY  ;
        float boundaryX = 0;
        float boundaryY = 0;

        switch(e2.getAction()) {
            case MotionEvent.ACTION_UP:
                AnimatorSet set = new AnimatorSet();
                AnimatorSet set2 = new AnimatorSet();




//                if (diffX <= Dwidth && diffY <= Dheight && diffX>= 0 && diffY>=0)
//
//                {
//                    set.setInterpolator(new DecelerateInterpolator());
//                    ObjectAnimator animX
//                            = ObjectAnimator.ofFloat(ball,"x" ,newX, diffX);
//                    ObjectAnimator animY
//                            = ObjectAnimator.ofFloat(ball, "y", newY, diffY);
//                    set.setDuration(500);
//
//                    set.play(animX).with(animY);
//                    set.start();
//
//                }
//
//                else
//
//                {
//
//                    set2.setInterpolator(new BounceInterpolator());
//
//
//                    float cutX= Dwidth/2 - newX ;
//                    float cutY=  Dheight/2 - newY ;
//
//
//                    //       boundaryX = calcFinalLoc(e2.getRawX(),Dwidth - ball.getWidth());
//
//                    boundaryX = calcFinalLoc(diffX, Dwidth - ball.getWidth(),(Dwidth - e2.getRawX())/2);
//                    boundaryY = calcFinalLoc(diffY,Dheight - ball.getHeight(),(Dheight - e2.getRawX())/2);
//
//
//
//                    ObjectAnimator animX2= ObjectAnimator.ofFloat(ball, "x", newX, boundaryX );
//                    ObjectAnimator animY2= ObjectAnimator.ofFloat(ball, "y", newY, boundaryY );
//                    set2.setDuration(500);
//                    set2.play(animX2).with(animY2);
//                    set2.start();
//                }


              //  set.setInterpolator(new BounceInterpolator());
                set.setInterpolator(new LinearInterpolator());


//           //         boundaryX = calcFinalLoc(diffX, Dwidth - ball.getWidth(),(Dwidth - e2.getRawX())/2);
//             //       boundaryY = calcFinalLoc(diffY,Dheight - ball.getHeight(),(Dheight - e2.getRawX())/2);





//
//                ObjectAnimator animX
//                        = ObjectAnimator.ofFloat(ball,"x" ,boundaryX, diffX);
//                ObjectAnimator animY
//                        = ObjectAnimator.ofFloat(ball, "y", boundaryY, diffY);

//
                ObjectAnimator animX
                            = ObjectAnimator.ofFloat(ball,"x" ,newX, diffX);
                    ObjectAnimator animY
                            = ObjectAnimator.ofFloat(ball, "y", newY, diffY);
                    set.setDuration(500);

                    set.play(animX).with(animY);
                    set.start();

                Log.v(TAG, "action up");

                break;
        }

        return true;
    }


    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub

//        myView.getResources().getDrawable(R.drawable.glass);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // TODO Auto-generated method stub



        return false;
    }

}
