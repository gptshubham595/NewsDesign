package ggps.shubham.newsfinal.thirdpage;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import ggps.shubham.newsfinal.R;
import ggps.shubham.newsfinal.secondpage.NewsAgriculture;
import ggps.shubham.newsfinal.secondpage.NewsBusiness;

public class NewsBusinessFull extends AppCompatActivity {
    int i=0;
    LinearLayout relative;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_business_full);
        relative=findViewById(R.id.layoutread);
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
                            Intent a =new Intent(getApplicationContext(),NewsBusiness.class);
                            a.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(a);
                        }
                    }
                },500);
            }
        });
    }
}


