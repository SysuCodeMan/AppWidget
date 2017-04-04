package com.example.chen.ex4;

import java.io.Serializable;

/**
 * Created by Chen on 2016/10/19.
 */

public class Fruit implements Serializable {
    private String name;
    private int picture;

    public Fruit(String name, int picture) {
        this.name = name;
        this.picture = picture;
    }
    public Fruit(Fruit other) {
        this.picture = other.picture;
        this.name = other.name;
    }

    public String getName() {
        return name;
    }
    public int getPicture() {
        return picture;
    }
}
