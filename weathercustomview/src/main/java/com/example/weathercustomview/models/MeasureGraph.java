package com.example.weathercustomview.models;

public class MeasureGraph {

    private int widthParent;
    private int heightParent;
    private int widthGraphview;
    private int heightGraphview;
    private float density = 1f;

    public MeasureGraph() {
    }

    public MeasureGraph(int widthParent, int heightParent) {
        this.widthParent = widthParent;
        this.heightParent = heightParent;
    }

    public int getWidthParent() {
        return widthParent;
    }

    public void setWidthParent(int widthParent) {
        this.widthParent = widthParent;
    }

    public int getHeightParent() {
        return heightParent;
    }

    public void setHeightParent(int heightParent) {
        this.heightParent = heightParent;
    }

    public int getWidthGraphview() {
        return widthGraphview;
    }

    public void setWidthGraphview(int widthGraphview) {
        this.widthGraphview = widthGraphview;
    }

    public int getHeightGraphview() {
        return heightGraphview;
    }

    public void setHeightGraphview(int heightGraphview) {
        this.heightGraphview = heightGraphview;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }
}
