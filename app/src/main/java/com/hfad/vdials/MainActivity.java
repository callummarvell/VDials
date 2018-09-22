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
        DialAdapter adapter = new DialAdapter(shipNames, shipDials);
        dialRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        dialRecycler.setLayoutManager(layoutManager);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /*Intent myIntent = new Intent(v.getContext(), AddActivity.class);
                v.getContext().startActivity(myIntent);*/
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.add_window,null);

                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                popupWindow.setAnimationStyle(R.style.PopupAnim);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window token
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
                frame.getForeground().setAlpha(220);

                Spinner spinner = popupView.findViewById(R.id.ship_selector);

                List<String> ships = new ArrayList<>();
                ships.add("TIE Advanced x1");
                ships.add("TIE Striker");
                ships.add("TIE Phantom");
                ships.add("TIE/ln Fighter");
                ships.add("TIE/fo Fighter");
                ships.add("Auzituck Gunship");
                ships.add("RZ-1 A-Wing");
                ships.add("T-65 X-Wing");
                ships.add("T-70 X-Wing");
                ships.add("BTL-A4 Y-Wing");
                ships.add("A/SF-01 B-Wing");
                ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_spinner_value, ships);
                spinner.setAdapter(spin_adapter);

                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        frame.getForeground().setAlpha(0);
                        return true;
                    }
                });

                Button add_btn = popupView.findViewById(R.id.confirm_add_button);

                add_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(view.getContext(), AddActivity.class);
                        view.getContext().startActivity(myIntent);
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
