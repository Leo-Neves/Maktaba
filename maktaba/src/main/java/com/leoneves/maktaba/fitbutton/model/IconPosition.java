package com.leoneves.maktaba.fitbutton.model;

public enum IconPosition {
    TOP(0),
    BOTTOM(1),
    LEFT(2),
    RIGHT(3),
    CENTER(4);
    private int position;
    IconPosition(int position){
        this.position=position;
    }
    
    public int getPosition(){
        return position;
    }
}
