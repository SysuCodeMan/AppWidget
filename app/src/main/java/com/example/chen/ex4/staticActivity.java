package com.example.chen.ex4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Chen on 2016/10/19.
 */

public class staticActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staticpage_layout);

        final MyAdapter myAdapter = new MyAdapter(this);
        ListView list = (ListView)findViewById(R.id.List);
        list.setAdapter(myAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String STATICACTION = "com.example.chen.ex4.staticreceiver";
                Fruit fruit = new Fruit((myAdapter.getFruitList().get(position)));
                Intent intent = new Intent(STATICACTION);
                Bundle bundle = new Bundle();
                bundle.putString("name", fruit.getName());
                bundle.putInt("drawableId", fruit.getPicture());
                intent.putExtras(bundle);
                sendBroadcast(intent);
            }
        });
    }
}
