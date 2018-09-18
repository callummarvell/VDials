package com.hfad.vdials;

public class Ship {
    private String name;
    private Maneuver[] dial;
    public static final Ship[] ships = {
            new Ship("Tie Advanced x1"),
            new Ship("Tie Silencer")
    };
    private Ship(String name) {
        Dials dials = new Dials();
        this.name = name;
        this.dial = dials.getDial(name);
    }
    public String getName() {
        return name;
    }
    public Maneuver[] getDial() {
        return dial;
    }
}
