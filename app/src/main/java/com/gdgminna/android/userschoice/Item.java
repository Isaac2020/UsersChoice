package com.gdgminna.android.userschoice;

import com.android.tonyvu.sc.model.Saleable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by MAGANI on 02/04/2018.
 */

public class Item implements Saleable, Serializable {
    private static final long serialVersionUID = -4073256626483275668L;

    private int Id;
    private String mName;
    private BigDecimal mUnitPrice;
    private int mImageResourceId;
    //private int mQuantity;

    public Item() {
        super();
    }

    public Item(String name, BigDecimal unitPrice, int quantity, int imageResourceId) {
        mName = name;
        mUnitPrice = unitPrice;
       // mQuantity = quantity;
        mImageResourceId = imageResourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Item)) return false;

        return (this.Id == ((Item) o).getId());
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = hash * prime + Id;
        hash = hash * prime + (mName == null ? 0 :mName .hashCode());
        hash = hash * prime + (mUnitPrice == null ? 0 : mUnitPrice.hashCode());
        //hash = hash * prime + (mQuantity == null ? 0 : mQuantity.hashCode());

        return hash;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }


    public String getName() {
        return mName;
    }

    public BigDecimal getUnitPrice() {
        return mUnitPrice;
    }

    //public int getQuantity() {return mQuantity;}

   // public void setQuantity(int quantity) {this.mQuantity = quantity;}


    public int getImageResourceId() {
        return mImageResourceId;
    }
}
