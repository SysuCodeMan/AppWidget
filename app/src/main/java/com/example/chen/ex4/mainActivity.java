package com.example.chen.ex4;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Chen on 2016/10/19.
 */

public class mainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mainpage_layout);

        Button Static = (Button)findViewById(R.id.StaticButton);
        Button Dynamic = (Button)findViewById(R.id.DynamicButton);

        Static.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mainActivity.this, staticActivity.class);
                startActivity(intent);
            }
        });

        Dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(mainActivity.this, dynamicActivity.class);
                startActivity(intent);
            }
        });
    }
}
