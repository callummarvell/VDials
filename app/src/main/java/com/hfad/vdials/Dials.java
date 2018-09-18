package com.hfad.vdials;

import java.util.HashMap;
import java.util.Map;

public class Dials{
    private Map<String, Maneuver[]> fleet = new HashMap<String, Maneuver[]>();
    public Dials(){
        this.buildDials();
    }
    private void buildDials() {
        Maneuver[] Advancedx1 = new Maneuver[18];
        Advancedx1[0] = new Maneuver(R.drawable.icon_maneuver_bank_left_blue,1);
        Advancedx1[1] = new Maneuver(R.drawable.icon_maneuver_bank_right_blue,1);
        Advancedx1[2] = new Maneuver(R.drawable.icon_maneuver_straight,1);
        Advancedx1[3] = new Maneuver(R.drawable.icon_maneuver_turn_left,2);
        Advancedx1[4] = new Maneuver(R.drawable.icon_maneuver_turn_right,2);
        Advancedx1[5] = new Maneuver(R.drawable.icon_maneuver_straight_blue,2);
        Advancedx1[6] = new Maneuver(R.drawable.icon_maneuver_bank_left_blue,2);
        Advancedx1[7] = new Maneuver(R.drawable.icon_maneuver_bank_right_blue,2);
        Advancedx1[8] = new Maneuver(R.drawable.icon_maneuver_turn_left,3);
        Advancedx1[9] = new Maneuver(R.drawable.icon_maneuver_turn_right,3);
        Advancedx1[10] = new Maneuver(R.drawable.icon_maneuver_bank_left,3);
        Advancedx1[11] = new Maneuver(R.drawable.icon_maneuver_bank_right,3);
        Advancedx1[12] = new Maneuver(R.drawable.icon_maneuver_straight_blue,3);
        Advancedx1[13] = new Maneuver(R.drawable.icon_maneuver_tallon_left_red,3);
        Advancedx1[14] = new Maneuver(R.drawable.icon_maneuver_tallon_right_red,3);
        Advancedx1[15] = new Maneuver(R.drawable.icon_maneuver_straight,4);
        Advancedx1[16] = new Maneuver(R.drawable.icon_maneuver_k_turn_red,4);
        Advancedx1[17] = new Maneuver(R.drawable.icon_maneuver_straight,5);
        fleet.put("Tie Advanced x1", Advancedx1);

        Maneuver[] Silencer = new Maneuver[16];
        Silencer[0] = new Maneuver(R.drawable.icon_maneuver_turn_left,1);
        Silencer[1] = new Maneuver(R.drawable.icon_maneuver_turn_right,1);
        Silencer[2] = new Maneuver(R.drawable.icon_maneuver_bank_left_blue,1);
        Silencer[3] = new Maneuver(R.drawable.icon_maneuver_bank_right_blue,1);
        Silencer[4] = new Maneuver(R.drawable.icon_maneuver_straight_blue,1);
        Silencer[5] = new Maneuver(R.drawable.icon_maneuver_k_turn_red,1);
        Silencer[6] = new Maneuver(R.drawable.icon_maneuver_turn_left,2);
        Silencer[7] = new Maneuver(R.drawable.icon_maneuver_turn_right,2);
        Silencer[8] = new Maneuver(R.drawable.icon_maneuver_bank_left_blue,2);
        Silencer[9] = new Maneuver(R.drawable.icon_maneuver_bank_right_blue,2);
        Silencer[10] = new Maneuver(R.drawable.icon_maneuver_straight_blue,2);
        Silencer[11] = new Maneuver(R.drawable.icon_maneuver_segnor_left_red,2);
        Silencer[12] = new Maneuver(R.drawable.icon_maneuver_segnor_right_red,2);
        Silencer[13] = new Maneuver(R.drawable.icon_maneuver_bank_left,3);
        Silencer[14] = new Maneuver(R.drawable.icon_maneuver_bank_right,3);
        Silencer[15] = new Maneuver(R.drawable.icon_maneuver_straight_blue,3);
        fleet.put("Tie Silencer", Silencer);
    }

    public Maneuver[] getDial(String name){
        return this.fleet.get(name);
    }
}