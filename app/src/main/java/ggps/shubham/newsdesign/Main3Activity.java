package ggps.shubham.newsdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements GestureDetector.OnGestureListener {
private ArrayList<String> al;
ViewFlipper viewFlipper;
public static  final int SWIPE_THRESHOLD=100;
    public static  final int SWIPE_VELOCITY_THRESHOLD=100;
private ArrayAdapter<String> arrayAdapter;
private int i;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        gestureDetector = new GestureDetector(this);

        viewFlipper=(ViewFlipper)findViewById(R.id.slide);
        int images[]={R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};
        /*for (int i=0;i<images.length;i++){
            flippimage(images[i]);
        }*/
        for(int image:images){
            flippimage(image);
        }

    }

    public void  flippimage(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this,R.anim.fadeinleft);
        viewFlipper.setOutAnimation(this,android.R.anim.fade_out);

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
        Intent a=new Intent(getApplicationContext(),Main2Activity.class);startActivity(a);
    }
    private void onSwipeLeft() {
        Toast.makeText(getApplicationContext(),"Left swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),MainActivity.class);startActivity(a);
    }
    private void onSwipeTop() {
        Toast.makeText(getApplicationContext(),"Top swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),Register.class);startActivity(a);
    }
    private void onSwipeBottom() {
        Toast.makeText(getApplicationContext(),"Down swipe",Toast.LENGTH_SHORT).show();
        Intent a=new Intent(getApplicationContext(),Main2Activity.class);startActivity(a);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
