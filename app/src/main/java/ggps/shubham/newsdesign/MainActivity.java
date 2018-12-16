package ggps.shubham.newsdesign;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import org.objectweb.asm.Handle;

public class MainActivity extends AppCompatActivity {
RelativeLayout relative;
    ViewFlipper viewFlipper;

int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            i++;
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(i==1){Toast.makeText(getApplicationContext(),"One Click",Toast.LENGTH_SHORT).show();}
                        else if(i>1){Toast.makeText(getApplicationContext(),"Double Click",Toast.LENGTH_SHORT).show();
                        Intent a =new Intent(getApplicationContext(),FullNews.class);
                        startActivity(a);
                        }
                    }
                },500);
            }
        });
    }
    public void  flippimage(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }

}
