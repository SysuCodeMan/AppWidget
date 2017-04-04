package com.example.chen.ex4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen on 2016/10/19.
 */

public class MyAdapter extends BaseAdapter {
    private List<Fruit> fruitList;
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
        fruitList = new ArrayList<Fruit>();
        fruitList.add(new Fruit("Apple", R.mipmap.apple));
        fruitList.add(new Fruit("Banana", R.mipmap.banana));
        fruitList.add(new Fruit("Cherry", R.mipmap.cherry));
        fruitList.add(new Fruit("Coco", R.mipmap.coco));
        fruitList.add(new Fruit("Kiwi", R.mipmap.kiwi));
        fruitList.add(new Fruit("Orange", R.mipmap.orange));
        fruitList.add(new Fruit("Pear", R.mipmap.pear));
        fruitList.add(new Fruit("Strawberry", R.mipmap.strawberry));
        fruitList.add(new Fruit("Watermelon", R.mipmap.watermelon));
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }
    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int position) {
        if (fruitList.isEmpty())
            return null;
        else
            return fruitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
        }
        ImageView picture = (ImageView)convertView.findViewById(R.id.Picture);
        TextView name = (TextView)convertView.findViewById(R.id.Name);

        picture.setImageResource(fruitList.get(position).getPicture());
        name.setText(fruitList.get(position).getName());

        return convertView;
    }
}
