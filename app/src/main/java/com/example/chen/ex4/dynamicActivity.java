package com.example.chen.ex4;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Chen on 2016/10/19.
 */

public class dynamicActivity extends AppCompatActivity {
    private String DYNAMICACTION = "com.example.chen.ex4.dynamicreceiver";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dynamicpage_layout);

        final Button controlButton = (Button) findViewById(R.id.control);
        final Button send = (Button) findViewById(R.id.send);
        final EditText toSend = (EditText) findViewById(R.id.toSend);
        final DynamicReceiver dynamicReceiver = new DynamicReceiver();
        controlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (controlButton.getText().equals("Register Broadcast")) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(DYNAMICACTION);
                    registerReceiver(dynamicReceiver, intentFilter);
                    controlButton.setText("Unregister Broadcast");
                } else {
                    unregisterReceiver(dynamicReceiver);
                    controlButton.setText("Register Broadcast");
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = toSend.getText().toString();
                Intent intent = new Intent(DYNAMICACTION);
                Bundle bundle = new Bundle();
                bundle.putString("message", message);
                intent.putExtras(bundle);
                sendBroadcast(intent);
            }
        });
    }
}
