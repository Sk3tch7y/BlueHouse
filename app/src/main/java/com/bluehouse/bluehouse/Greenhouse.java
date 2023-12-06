package com.bluehouse.bluehouse;
import java.io.Serializable;
import java.util.ArrayList;

public class Greenhouse implements Serializable {
    private String name;
    private boolean temp;
    boolean humidity;
    boolean light;
    ArrayList<Plant> plants;
    public Greenhouse(String name, boolean temp, boolean humidity, boolean light, ArrayList<Plant> plants){
        this.name = name;
        this.temp = temp;
        this.humidity = humidity;
        this.light = light;
        this.plants = plants;
    }
    public String getName(){
        return name;
    }
    public boolean getTemp(){
        return temp;
    }
    public boolean getHumidity(){
        return humidity;
    }
    public boolean getLight(){
        return light;
    }
    public ArrayList<Plant> getPlants(){
        return plants;
    }
}
