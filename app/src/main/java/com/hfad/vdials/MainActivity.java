package com.hfad.vdials;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FrameLayout frame = findViewById(R.id.frame);
        frame.getForeground().setAlpha(0);
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
        final DialAdapter adapter = new DialAdapter(shipNames, shipDials);
        dialRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        dialRecycler.setLayoutManager(layoutManager);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*Intent myIntent = new Intent(v.getContext(), AddActivity.class);
                v.getContext().startActivity(myIntent);*/
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                final View popupView = inflater.inflate(R.layout.add_window,null);

                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                popupWindow.setAnimationStyle(R.style.PopupAnim);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window token
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
                frame.getForeground().setAlpha(240);

                Spinner spinner = popupView.findViewById(R.id.ship_selector);

                List<String> ships = new ArrayList<>();
                for (Ship ship:Ship.all_ships) {
                    if (ship!=null)
                        if (!ships.contains(ship.getName()))
                            ships.add(ship.getName());
                }
                ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_spinner_value, ships);
                spinner.setAdapter(spin_adapter);

                // dismiss the popup window when touched
                /*popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        frame.getForeground().setAlpha(0);
                        return true;
                    }
                });*/

                Button add_btn = popupView.findViewById(R.id.confirm_add_button);

                add_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Spinner spinner = popupView.findViewById(R.id.ship_selector);
                        String selection = spinner.getSelectedItem().toString();
                        Log.i("selection",selection);
                        //Intent myIntent = new Intent(view.getContext(), AddActivity.class);
                        //view.getContext().startActivity(myIntent);
                        //Ship[] old_ships = Ship.ships;
                        Ship[] new_ships = new Ship[Ship.ships.length+1];
                        for (int i=0;i<Ship.ships.length;i++){
                            new_ships[i] = Ship.ships[i];
                        }
                        Ship newship = new Ship(selection);
                        new_ships[Ship.ships.length] = newship;
                        Ship.ships = new_ships;
                        adapter.dataChange(newship);
                    }
                });

                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        //Do Something here
                        frame.getForeground().setAlpha(0);
                    }
                });
            }
        });
    }

}
