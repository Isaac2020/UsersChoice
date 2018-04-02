package com.gdgminna.android.userschoice;

/**
 * Created by MAGANI on 02/04/2018.
 */

public class Item {
    private String mName;
    private int mPrice;
    private  int mImageResourceId;

    public Item(String name, int price, int imageResourceId){
        mName = name;
        mPrice = price;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }
    public int getmPrice(){
        return mPrice;
    }
    public int getmImageResourceId(){
        return mImageResourceId;
    }
}
