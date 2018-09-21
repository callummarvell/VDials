package com.hfad.vdials;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("RUNNING", "onCreateView is running");
        RecyclerView dialRecycler = findViewById(R.id.dial_recycler);
        String[] shipNames = new String[Ship.ships.length];
        for (int i = 0; i < shipNames.length; i++) {
            shipNames[i] = Ship.ships[i].getName();
        }
        Maneuver[][] shipDials = new Maneuver[Ship.ships.length][];
        for (int i = 0; i < shipDials.length; i++) {
            shipDials[i] = Ship.ships[i].getDial();
        }
        DialAdapter adapter = new DialAdapter(shipNames, shipDials);
        dialRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        dialRecycler.setLayoutManager(layoutManager);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), AddActivity.class);
                v.getContext().startActivity(myIntent);
            }
        });
    }

}
