package com.yayandroid.locationmanager.sample
.firstpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.yayandroid.locationmanager.sample.R;
import com.yayandroid.locationmanager.sample.secondpage.NewsSports;
import maes.tech.intentanim.CustomIntent;

public class MainScreenBottom extends AppCompatActivity implements GestureDetector.OnGestureListener{

    public static  final int SWIPE_THRESHOLD=100;
    public static  final int SWIPE_VELOCITY_THRESHOLD=100;
    private GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_bottom);
        gestureDetector = new GestureDetector(this);
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
        Toast.makeText(getApplicationContext(),"No Card Left",Toast.LENGTH_SHORT).show();
    }
    private void onSwipeLeft() {
        Toast.makeText(getApplicationContext(),"Left Swipe",Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"No Card Left",Toast.LENGTH_SHORT).show();

    }
    private void onSwipeTop() {
        Toast.makeText(getApplicationContext(),"Bottom Swipe",Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"No Card Left",Toast.LENGTH_SHORT).show();

    }
    private void onSwipeBottom() {
        Toast.makeText(getApplicationContext(),"Top swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),MainScreen.class);startActivity(a);
        CustomIntent.customType(this,"bottom-to-top");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
