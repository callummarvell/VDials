package com.hfad.vdials;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SpinnerAdapter extends ArrayAdapter<Maneuver>{
    private Context context;
    private Maneuver[] maneuever_array;

    public SpinnerAdapter(Context context, int resource, Maneuver[] maneuvers){
        super(context,  R.layout.spinner_value_layout, R.id.spinnerText, maneuvers);
        this.context = context;
        this.maneuever_array = maneuvers;
    }

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.spinner_value_layout, null);

        }

        TextView textView = (TextView) convertView.findViewById(R.id.spinnerText);
        textView.setText(Integer.toString(maneuever_array[position].getSpeed()));

        ImageView imageView = (ImageView)convertView.findViewById(R.id.spinnerImages);
        imageView.setImageResource(maneuever_array[position].getImageResourceId());

        return convertView;
    }*/

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_value_layout, parent, false);

        TextView textView = (TextView) row.findViewById(R.id.spinnerText);
        textView.setText(Integer.toString(maneuever_array[position].getSpeed()));

        ImageView imageView = (ImageView)row.findViewById(R.id.spinnerImages);
        imageView.setImageResource(maneuever_array[position].getImageResourceId());

        return row;
    }
}
