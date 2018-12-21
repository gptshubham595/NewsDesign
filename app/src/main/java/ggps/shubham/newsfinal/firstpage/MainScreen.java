package ggps.shubham.newsfinal.firstpage;

import android.app.ActivityOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.Manifest;

import ggps.shubham.newsfinal.MyFirebaseInstanceId;
import ggps.shubham.newsfinal.R;
import ggps.shubham.newsfinal.SharedPrefManager;
import ggps.shubham.newsfinal.secondpage.NewsSports;
import maes.tech.intentanim.CustomIntent;

import android.view.GestureDetector;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainScreen extends AppCompatActivity  implements GestureDetector.OnGestureListener{
    String Tokensave;
    private TextView token;
    private BroadcastReceiver broadcastReceiver;
    private DatabaseReference storeuserdata;
    private FirebaseAuth mauth;
    public static  final int SWIPE_THRESHOLD=100;
    public static  final int SWIPE_VELOCITY_THRESHOLD=100;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        gestureDetector = new GestureDetector(this);
        token=findViewById(R.id.token);
        broadcastReceiver=new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                token.setText(SharedPrefManager.getInstance(MainScreen.this).getToken());
                Tokensave=token.getText().toString();
            }
        };
        registerReceiver(broadcastReceiver,new IntentFilter(MyFirebaseInstanceId.TOKEN_BROADCAST));

//        storeuserdata= FirebaseDatabase.getInstance().getReference().child("Users").child(Tokensave);

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
        Intent a=new Intent(getApplicationContext(),MainScreenRight.class);startActivity(a);
        CustomIntent.customType(this,"right-to-left");
    }
    private void onSwipeLeft() {
        Toast.makeText(getApplicationContext(),"Left swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),NewsSports.class);
        startActivity(a);
        CustomIntent.customType(this,"left-to-right");
    }
    private void onSwipeTop() {
        Toast.makeText(getApplicationContext(),"Down swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),MainScreenBottom.class);startActivity(a);

        CustomIntent.customType(this,"bottom-to-top");
    }
    private void onSwipeBottom() {
        Toast.makeText(getApplicationContext(),"Top swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),MainScreenTop.class);startActivity(a);
        CustomIntent.customType(this,"top-to-bottom");
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
