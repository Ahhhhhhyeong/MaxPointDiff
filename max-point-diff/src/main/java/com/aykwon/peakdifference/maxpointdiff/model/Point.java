package com.aykwon.peakdifference.maxpointdiff.model;

public class Point {
    private int st_id;
    private int idx_x;
    private int idx_y;
    private double lon;
    private double lat;

    //기본 생성자
    public Point() {}

    //전체 필드를 포함한 생성자
    public Point(int st_id, int idx_x, int idx_y, double lon, double lat){
        this.st_id = st_id;
        this.idx_x = idx_x;
        this.idx_y = idx_y;
        this.lon = lon;
        this.lat = lat;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public int getIdx_x() {
        return idx_x;
    }

    public void setIdx_x(int idx_x) {
        this.idx_x = idx_x;
    }

    public int getIdx_y() {
        return idx_y;
    }

    public void setIdx_y(int idx_y) {
        this.idx_y = idx_y;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    };
}
