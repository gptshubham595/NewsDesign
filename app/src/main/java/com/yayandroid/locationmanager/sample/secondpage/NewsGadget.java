package com.yayandroid.locationmanager.sample
.secondpage;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.yayandroid.locationmanager.sample.R;
import com.yayandroid.locationmanager.sample.firstpage.MainScreen;
import com.yayandroid.locationmanager.sample.thirdpage.NewsGadgetFull;
import com.yayandroid.locationmanager.sample.thirdpage.NewsSportsFull;
import maes.tech.intentanim.CustomIntent;

public class NewsGadget extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener{
    public static  final int SWIPE_THRESHOLD=100;
    public static  final int SWIPE_VELOCITY_THRESHOLD=100;
    private GestureDetector gestureDetector;
    ViewFlipper viewFlipper;
    RelativeLayout relative;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_gadget);
        gestureDetector = new GestureDetector(this);
        Toast.makeText(getApplicationContext(),"Gadgets News Here",Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Double Tap to read complete news",Toast.LENGTH_SHORT).show();
        viewFlipper=(ViewFlipper)findViewById(R.id.slide);
        int images[]={R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};
        /*for (int i=0;i<images.length;i++){
            flippimage(images[i]);
        }*/
        for(int image:images){
            flippimage(image);
        }

        relative=findViewById(R.id.layout);


    }
    public void  flippimage(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(1800);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent downevent, MotionEvent moveevent, float velocityX, float velocityY) {
        boolean result=false;
        float diffY=moveevent.getY() - downevent.getY();
        float diffX=moveevent.getX() - downevent.getX();
        if(Math.abs(diffX)>Math.abs(diffY)){
            //right or left swipe
            result=true;
            if(Math.abs(diffX)>SWIPE_THRESHOLD && Math.abs(velocityX)>SWIPE_VELOCITY_THRESHOLD ){
                if(diffX>0){onSwipeRight();}
                else {onSwipeLeft();}

            }

        }
        else{
            //up or down swipe
            result=true;
            if(Math.abs(diffY)>SWIPE_THRESHOLD && Math.abs(velocityY)>SWIPE_VELOCITY_THRESHOLD){
                if(diffY>0){onSwipeBottom();}
                else{onSwipeTop();}
            }
        }

        return result;
    }

    private void onSwipeRight() {
        Toast.makeText(getApplicationContext(),"Right swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),MainScreen.class);startActivity(a);
        CustomIntent.customType(this,"right-to-left");
    }
    private void onSwipeLeft() {
        Toast.makeText(getApplicationContext(),"Left swipe",Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"Sub Topic",Toast.LENGTH_SHORT).show();
    }
    private void onSwipeBottom() {
        Toast.makeText(getApplicationContext(),"Top swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),NewsLifestyle.class);startActivity(a);
        CustomIntent.customType(this,"bottom-to-top");
    }
    private void onSwipeTop() {
        Toast.makeText(getApplicationContext(),"Down swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),NewsEntertainment .class);startActivity(a);
        CustomIntent.customType(this,"top-to-bottom");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Intent a = new Intent(getApplicationContext(),NewsGadgetFull.class);
        startActivity(a);
        CustomIntent.customType(getApplicationContext(),"left-to-right");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        return false;
    }
}
