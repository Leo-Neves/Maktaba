package com.leoneves.maktaba.fitbutton.model;

public enum Shape {
    RECTANGLE(0),
    SQUARE(1),
    CIRCLE(2),
    OVAL(3);
    private int shape;
    Shape(int shape){
        this.shape = shape;
    }

    public int getShape(){
        return shape;
    }
}
