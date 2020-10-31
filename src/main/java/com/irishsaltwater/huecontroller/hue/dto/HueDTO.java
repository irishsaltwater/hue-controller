package com.irishsaltwater.huecontroller.hue.dto;

import java.util.ArrayList;
import java.util.List;

public class HueDTO {

    private boolean on;
    private Integer bri;
    private Integer hue;
    private Integer sat;
    private List<Double> xy;

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public Integer getBri() {
        return bri;
    }

    public void setBri(Integer bri) {
        this.bri = bri;
    }

    public Integer getHue() {
        return hue;
    }

    public void setHue(Integer hue) {
        this.hue = hue;
    }

    public Integer getSat() {
        return sat;
    }

    public void setSat(Integer sat) {
        this.sat = sat;
    }

    public List<Double> getXy() {
        if(xy == null){
            xy = new ArrayList<Double>();
            return xy;
        }
        return xy;
    }

    public void setXy(List<Double> xy) {
        this.xy = xy;
    }
}
