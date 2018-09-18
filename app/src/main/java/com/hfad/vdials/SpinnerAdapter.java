package com.hfad.vdials;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class SpinnerAdapter extends ArrayAdapter<Maneuver>{
    private Context context;
    private Maneuver[] maneuever_array;
    private int[] blues = new int [14];

    public SpinnerAdapter(Context context, int resource, Maneuver[] maneuvers){
        super(context,  R.layout.spinner_value_layout, R.id.spinnerText, maneuvers);
        this.context = context;
        this.maneuever_array = maneuvers;
        blues[0] = R.drawable.icon_maneuver_bank_left_blue;
        blues[1] = R.drawable.icon_maneuver_bank_right_blue;
        blues[2] = R.drawable.icon_maneuver_turn_left_blue;
        blues[3] = R.drawable.icon_maneuver_turn_right_blue;
        blues[4] = R.drawable.icon_maneuver_segnor_left_blue;
        blues[5] = R.drawable.icon_maneuver_segnor_right_blue;
        blues[6] = R.drawable.icon_maneuver_k_turn_blue;
        blues[7] = R.drawable.icon_maneuver_stop_blue;
        blues[8] = R.drawable.icon_maneuver_reverse_bank_left_blue;
        blues[9] = R.drawable.icon_maneuver_reverse_bank_right_blue;
        blues[10] = R.drawable.icon_maneuver_reverse_straight_blue;
        blues[11] = R.drawable.icon_maneuver_tallon_left_blue;
        blues[12] = R.drawable.icon_maneuver_tallon_right_blue;
        blues[13] = R.drawable.icon_maneuver_straight_blue;
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
        int imid = maneuever_array[position].getImageResourceId();
        imageView.setImageResource(imid);

        if(ArrayUtils.contains(blues,imid))
            imageView.setColorFilter(ContextCompat.getColor(context, R.color.maneuverBlue), android.graphics.PorterDuff.Mode.MULTIPLY);

        return row;
    }
}
