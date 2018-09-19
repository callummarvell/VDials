package com.hfad.vdials;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Spinner;

public class DialFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("RUNNING","onCreateView is running");
        RecyclerView dialRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_dial, container, false);
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        dialRecycler.setLayoutManager(layoutManager);
        return dialRecycler;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("RUNNING","onAttach is running");
        RecyclerView dialRecycler = getView().findViewById(R.id.dial_recycler);
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        dialRecycler.setLayoutManager(layoutManager);
    }

}