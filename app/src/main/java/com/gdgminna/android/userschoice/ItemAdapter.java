package com.gdgminna.android.userschoice;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tonyvu.sc.model.Cart;
import com.android.tonyvu.sc.util.CartHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        TextView name;
        TextView unitPrice;
        ImageView imageView;
        final Spinner quantity;
        Button button;
        Item item;

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Item currentItem = getItem(position);

        name = listItemView.findViewById(R.id.name_textview);
        name.setText(currentItem.getName());

        unitPrice = listItemView.findViewById(R.id.price_textview);
        unitPrice.setText(Constant.CURRENCY + String.valueOf(currentItem.getUnitPrice().setScale(0, BigDecimal.ROUND_HALF_UP)));
        ;

        imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentItem.getImageResourceId());

        quantity = listItemView.findViewById(R.id.quantity);
        final List<Integer> QUANTITY_LIST = new ArrayList<Integer>();

            for (int i = 1; i < 6; i++) QUANTITY_LIST.add(i);

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(getContext(), android.R.layout.simple_spinner_item, QUANTITY_LIST);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantity.setAdapter(dataAdapter);

        //quantity.setText(Integer.valueOf(quantity.getSelectedItem().toString()));
        button = listItemView.findViewById(R.id.add_to_cart);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "added" + " " + currentItem.getName() + " " + "to cart", Toast.LENGTH_SHORT).show();
                Cart cart = CartHelper.getCart();
                Log.d(TAG, "Adding product: " + currentItem.getName());
                cart.add(currentItem, Integer.valueOf(quantity.getSelectedItem().toString()));
               // Intent intent = new Intent(getContext(), CartActivity.class);
                //startActivity(intent);
            }
        });


        return listItemView;
    }

}
