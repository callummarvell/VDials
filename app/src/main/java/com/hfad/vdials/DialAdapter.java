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

class DialAdapter extends RecyclerView.Adapter<DialAdapter.ViewHolder>{

    private String[] names;
    private Maneuver[][] dials;

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
        this.names = names;
        this.dials = dials;
    }

    @Override
    public int getItemCount(){
        return names.length;
    }

    @Override
    public DialAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_dial, parent, false);
        return new ViewHolder(cv);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        final CardView cardView = holder.cardView;
        TextView textView = (TextView)cardView.findViewById(R.id.ship_name);
        textView.setText(names[position]);
        Spinner spinner = (Spinner)cardView.findViewById(R.id.dial_spinner);
        SpinnerAdapter adapter = new SpinnerAdapter(cardView.getContext(), R.layout.spinner_value_layout, dials[position]);
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

            }
        });
    }

}


