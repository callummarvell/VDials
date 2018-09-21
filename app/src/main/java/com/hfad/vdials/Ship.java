package com.hfad.vdials;

public class Ship {
    private String name;
    private Maneuver[] dial;
    public static final Ship[] ships = {
            new Ship("TIE Advanced x1"),
            new Ship("TIE Striker"),
            new Ship("TIE Phantom"),
            new Ship("TIE/ln Fighter"),
            new Ship("TIE/fo Fighter"),
            new Ship("Auzituck Gunship"),
            new Ship("RZ-1 A-Wing"),
            new Ship("T-65 X-Wing"),
            new Ship("T-70 X-Wing"),
            new Ship("BTL-A4 Y-Wing"),
            new Ship("A/SF-01 B-Wing")
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
