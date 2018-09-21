package com.hfad.vdials;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

class DialAdapter extends RecyclerView.Adapter<DialAdapter.ViewHolder>{

    private ArrayList<String> names;
    private ArrayList<Maneuver[]> dials;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public Button edit_button;
        public Button show_button;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
            this.edit_button = (Button)v.findViewById(R.id.edit_button);
            this.show_button = (Button)v.findViewById(R.id.show_button);
        }
    }

    public DialAdapter(String[] names, Maneuver[][] dials){
        this.names = new ArrayList<>(Arrays.asList(names));
        this.dials = new ArrayList<>(Arrays.asList(dials));
    }

    @Override
    public int getItemCount(){
        return names.size();
    }

    @Override
    public DialAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_dial, parent, false);
        return new ViewHolder(cv);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        final CardView cardView = holder.cardView;
        TextView textView = (TextView)cardView.findViewById(R.id.ship_name);
        textView.setText(names.get(position));
        Spinner spinner = (Spinner)cardView.findViewById(R.id.dial_spinner);
        SpinnerAdapter adapter = new SpinnerAdapter(cardView.getContext(), R.layout.spinner_value_layout, dials.get(position));
        spinner.setAdapter(adapter);
        holder.show_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("INVIS VALUE",Integer.toString(View.INVISIBLE));
                Log.i("VIS VALUE",Integer.toString(View.VISIBLE));

                Spinner spinner = (Spinner) cardView.findViewById(R.id.dial_spinner);
                spinner.setVisibility(View.INVISIBLE-spinner.getVisibility());
                Log.i("spinner value",Integer.toString(spinner.getVisibility()));
            }
        });
        holder.edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                names.remove(position);
                dials.remove(position);
                notifyDataSetChanged();
            }
        });
    }

}


