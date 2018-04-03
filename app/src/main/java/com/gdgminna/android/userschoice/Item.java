package com.gdgminna.android.userschoice;

/**
 * Created by MAGANI on 02/04/2018.
 */

public class Item {
    private String mName;
    private String mPrice;
    private  int mImageResourceId;

    public Item(String name, String price, int imageResourceId) {
        mName = name;
        mPrice = price;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getPrice() {
        return mPrice;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
