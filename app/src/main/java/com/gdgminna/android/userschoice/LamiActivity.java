package com.gdgminna.android.userschoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class LamiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Rice", BigDecimal.valueOf(200), 1, R.drawable.rice));
        items.add(new Item("Egusi soup", BigDecimal.valueOf(200),1, R.drawable.egusi_soup));
        items.add(new Item("Chicken", BigDecimal.valueOf(200), 1, R.drawable.chicken));
        items.add(new Item("Jellof rice", BigDecimal.valueOf(300.00),1, R.drawable.jollof));
        items.add(new Item("Beef", BigDecimal.valueOf(200),0, R.drawable.meat));
        items.add(new Item("Amala", BigDecimal.valueOf(200),0, R.drawable.amala));
        items.add(new Item("Banga", BigDecimal.valueOf(200),0, R.drawable.bamga));
        items.add(new Item("Spagheti & Chicken", BigDecimal.valueOf(200),0, R.drawable.spackswithchicken));



        ItemAdapter adapter = new ItemAdapter(this, items);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            Intent intent = new Intent(LamiActivity.this, CartActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
