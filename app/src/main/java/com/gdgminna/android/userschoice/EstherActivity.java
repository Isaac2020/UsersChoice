package com.gdgminna.android.userschoice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class EstherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Rice", "N100", R.drawable.rice));
        items.add(new Item("Rice", "N100", R.drawable.egusi_soup));
        items.add(new Item("Rice", "N200", R.drawable.chicken));
        items.add(new Item("Rice", "N100", R.drawable.jollof));
        items.add(new Item("Rice", "N100", R.drawable.meat));
        items.add(new Item("Rice", "N150", R.drawable.amala));
        items.add(new Item("Rice", "N100", R.drawable.bamga));
        items.add(new Item("Rice", "N100", R.drawable.spackswithchicken));


        ItemAdapter adapter = new ItemAdapter(this,items);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}
