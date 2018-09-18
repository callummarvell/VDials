package com.hfad.vdials;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

class DialAdapter extends RecyclerView.Adapter<DialAdapter.ViewHolder>{

    private String[] names;
    private Maneuver[][] dials;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
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
        CardView cardView = holder.cardView;
        TextView textView = (TextView)cardView.findViewById(R.id.ship_name);
        textView.setText(names[position]);
    }

}


