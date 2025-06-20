package edu.gatech.seclass.jobcomparisonapp;
import java.io.Serializable;
public class Location implements Serializable {
    private String city;
    private String state;
    private int costOfLiving;

    public Location(String city, String state, int costOfLiving) {
        this.city = city;
        this.state = state;
        this.costOfLiving = costOfLiving;
    }

    public String getCity() { return city; }
    public String getState() { return state; }
    public int getCostOfLiving() { return costOfLiving; }
}

