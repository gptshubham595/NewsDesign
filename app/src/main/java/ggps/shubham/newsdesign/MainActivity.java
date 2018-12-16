package ggps.shubham.newsdesign;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.objectweb.asm.Handle;

public class MainActivity extends AppCompatActivity {
RelativeLayout relative;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

}
