package com.gdgminna.android.userschoice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class LamiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Rice", "N100", R.drawable.michga_foods));
        items.add(new Item("Rice", "N100", R.drawable.michga_foods));
        items.add(new Item("Rice", "N100", R.drawable.michga_foods));
        items.add(new Item("Rice", "N100", R.drawable.michga_foods));
        items.add(new Item("Rice", "N100", R.drawable.michga_foods));
        items.add(new Item("Rice", "N100", R.drawable.michga_foods));

        ItemAdapter adapter = new ItemAdapter(this, items);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
