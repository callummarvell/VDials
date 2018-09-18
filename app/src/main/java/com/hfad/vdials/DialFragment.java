package com.hfad.vdials;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
public class DialFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
}