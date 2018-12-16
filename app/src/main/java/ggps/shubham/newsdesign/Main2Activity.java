package ggps.shubham.newsdesign;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;

public class Main2Activity extends AppCompatActivity {
Button  signin,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        signin=findViewById(R.id.signin);
        register=findViewById(R.id.register);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Sign In Button Clicked",Toast.LENGTH_SHORT).show();
                                        }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "Register Button Clicked", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(getApplicationContext(),Register.class);
                startActivity(a);
            }
        });
    }
}
