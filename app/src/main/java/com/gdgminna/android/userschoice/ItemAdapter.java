package com.gdgminna.android.userschoice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by MAGANI on 02/04/2018.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    private static final String TAG = "ItemAdapter";

    public ItemAdapter(Activity context, ArrayList<Item> item) {
        super(context, 0, item);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Item currentItem = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.name_textview);
        nameTextView.setText(currentItem.getName());

        TextView pricetextView = listItemView.findViewById(R.id.price_textview);
        pricetextView.setText(Constant.CURRENCY + String.valueOf(currentItem.getPrice().setScale(2, BigDecimal.ROUND_HALF_UP)));
        ;

        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentItem.getImageResourceId());

        Button button = listItemView.findViewById(R.id.add_to_cart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "added to cart" + position, Toast.LENGTH_SHORT).show();
            }
        });

        return listItemView;
    }


}
