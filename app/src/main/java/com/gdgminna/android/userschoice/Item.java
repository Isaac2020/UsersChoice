package com.gdgminna.android.userschoice;

import com.android.tonyvu.sc.model.Saleable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by MAGANI on 02/04/2018.
 */

public class Item implements Saleable, Serializable {
    private String mName;
    private BigDecimal mUnitPrice;
    private  int mImageResourceId;

    public Item(String name, BigDecimal price, int imageResourceId) {
        mName = name;
        mUnitPrice = price;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public BigDecimal getPrice() {
        return mUnitPrice;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
