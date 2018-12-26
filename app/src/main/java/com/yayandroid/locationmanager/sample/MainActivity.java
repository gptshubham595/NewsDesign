package com.yayandroid.locationmanager.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.yayandroid.locationmanager.sample.activity.SampleActivity;
import com.yayandroid.locationmanager.sample.firstpage.MainScreen;
import com.yayandroid.locationmanager.sample.fragment.SampleFragmentActivity;
import com.yayandroid.locationmanager.sample.service.SampleServiceActivity;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {
    Thread a;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                }
                catch (Exception e){e.printStackTrace();}
                finally {
                    Intent a=new Intent(getApplicationContext(),MainScreen.class);
                    startActivity(a);

                }
            }
        };
        a.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


    public void inActivityClick(View view) {
        startActivity(new Intent(this, SampleActivity.class));
    }

    public void inFragmentClick(View view) {
        //startActivity(new Intent(this, SampleFragmentActivity.class));
    }

    public void inServiceClick(View view) {
        //startActivity(new Intent(this, SampleServiceActivity.class));
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
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
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
