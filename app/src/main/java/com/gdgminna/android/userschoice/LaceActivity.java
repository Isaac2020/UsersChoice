package com.gdgminna.android.userschoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.math.BigDecimal;
import java.util.ArrayList;

public class LaceActivity extends AppCompatActivity {


    Intent intent;
    Spinner Quantity;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Rice", BigDecimal.valueOf(200), R.drawable.rice));
        items.add(new Item("Egusi soup", BigDecimal.valueOf(200), R.drawable.egusi_soup));
        items.add(new Item("Chicken", BigDecimal.valueOf(200), R.drawable.chicken));
        items.add(new Item("Jellof rice", BigDecimal.valueOf(300.00), R.drawable.jollof));
        items.add(new Item("Beef", BigDecimal.valueOf(200), R.drawable.meat));
        items.add(new Item("Amala", BigDecimal.valueOf(200), R.drawable.amala));
        items.add(new Item("Banga", BigDecimal.valueOf(200), R.drawable.bamga));
        items.add(new Item("Spagheti & Chicken", BigDecimal.valueOf(200), R.drawable.spackswithchicken));


        ItemAdapter adapter = new ItemAdapter(this, items);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, Constant.QUANTITY_LIST);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Quantity.setAdapter(dataAdapter);

        Button addToCart = findViewById(R.id.add_to_cart);
        /**addToCart.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
        // Cart cart = CartHelper.getCart();
        //Log.d(TAG, "Adding product: " + items.getName());
        // cart.add(item, Integer.valueOf(Quantity.getSelectedItem().toString()));
        Intent intent = new Intent(LaceActivity.this, CartActivity.class);
        startActivity(intent);
        }
        });**/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            intent = new Intent(LaceActivity.this, CartActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}