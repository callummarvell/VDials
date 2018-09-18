package com.hfad.vdials;

public class Maneuver {
    private int imageResourceId;
    private int speed;

    public Maneuver(int im, int sp){
        this.imageResourceId = im;
        this.speed = sp;
    }

    public int getSpeed(){
        return speed;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }
}
