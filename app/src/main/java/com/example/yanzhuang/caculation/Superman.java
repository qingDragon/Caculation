package com.example.yanzhuang.caculation;

/**
 * Created by yanzhuang on 2017/6/15.
 */

public class Superman {
    private String name;
    private int imageId;
    private String num;
    public Superman(String name, int imageId,String num) {
        this.name = name;
        this.imageId = imageId;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public int getImageId () {
        return imageId;
    }

    public String getNum() {
        return num;
    }

    public String toString() {
        return name + num;
    }
}
