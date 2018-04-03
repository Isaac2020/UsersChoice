package com.gdgminna.android.userschoice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MAGANI on 02/04/2018.
 */

public class ItemAdapter extends ArrayAdapter<Item>{

    public ItemAdapter (Activity context, ArrayList<Item> Item){
        super(context, 0,Item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Item currentItem = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.name_textview);
        nameTextView.setText(currentItem.getName());

        TextView pricetextView = listItemView.findViewById(R.id.price_textview);
        pricetextView.setText(currentItem.getPrice());

        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentItem.getImageResourceId());

        return listItemView;
    }
}
