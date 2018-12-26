package com.yayandroid.locationmanager.sample
.firstpage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.Manifest;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yayandroid.locationmanager.sample.R;
import com.yayandroid.locationmanager.sample.secondpage.NewsSports;

import android.view.GestureDetector;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import android.app.Dialog;

import maes.tech.intentanim.CustomIntent;

public class MainScreen extends AppCompatActivity  implements GestureDetector.OnGestureListener{

    TextView textView;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    public static  final int SWIPE_THRESHOLD=100;
    public static  final int SWIPE_VELOCITY_THRESHOLD=100;
    private GestureDetector gestureDetector;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        textView=(TextView) findViewById(R.id.token);
//--------------------------------------------------------

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                textView.setText(value);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

//-----------------------------------------------------
        gestureDetector = new GestureDetector(this);
        dialog = new Dialog(this);
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            dialog.setContentView(R.layout.instruction_dialog);
            dialog.show();
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).apply();
        }
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
        Intent a=new Intent(getApplicationContext(),MainScreenRight.class);
        CustomIntent.customType(MainScreen.this,"right-to-left");
        startActivity(a);
    }
    private void onSwipeLeft() {
        Toast.makeText(getApplicationContext(),"Left swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),NewsSports.class);
        CustomIntent.customType(MainScreen.this,"left-to-right");
        startActivity(a);
    }
    private void onSwipeBottom() {
        Toast.makeText(getApplicationContext(),"Top swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),MainScreenTop.class);
        CustomIntent.customType(MainScreen.this,"bottom-to-up");
        startActivity(a);
    }
    private void onSwipeTop() {
        Toast.makeText(getApplicationContext(),"Down swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),MainScreenBottom.class);
        CustomIntent.customType(MainScreen.this,"up-to-bottom");
        startActivity(a);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
