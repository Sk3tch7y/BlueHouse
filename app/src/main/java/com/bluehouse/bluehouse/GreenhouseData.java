package com.bluehouse.bluehouse;
import java.util.ArrayList;

public class GreenhouseData {


   //greenHouse identifiers
    private int id;
    private String name;

    //tracked properties
    private boolean tempTracked;
    private boolean humidityTracked;
    private boolean lightTracked;


    //current stats
    private String currentTemp;
    private String currentHumidity;
    private String currentLight;
    private String currentOther;


    //plant arrayList
    ArrayList<Plant> plants;



    public GreenhouseData(String name, boolean temp, boolean humidity, boolean light, ArrayList<Plant> plants){
        this.name = name;
        this.tempTracked = temp;
        this.humidityTracked = humidity;
        this.lightTracked = light;
        this.plants = plants;
    }
    public GreenhouseData(int id, String name, boolean temp, boolean humidity, boolean light){
        this.id = id;
        this.name = name;
        this.tempTracked = temp;
        this.humidityTracked = humidity;
        this.lightTracked = light;
    }

    //getter for the greenhouse identifiers
    public int getId()  {
        return id;
    }
    public String getName(){
        return name;
    }

    //getters for the tracked greenhouse attributes
    public boolean getTempTracked(){
        return tempTracked;
    }
    public boolean getHumidityTracked(){
        return humidityTracked;
    }
    public boolean getLightTracked(){
        return lightTracked;
    }

    //getters for the current greenhouse stats
    public String getCurrentTemp()  {
        return currentTemp;

    }
    public String getCurrentHumidity()  {
        return currentHumidity;
    }
    public String getCurrentLight() {
        return currentLight;
    }
    public String getCurrentOther() {
        return currentOther;
    }



    //setters for the current greenhouse stats
    public void setCurrentTemp(String currentTemp)  {
        this.currentTemp = currentTemp;
    }
    public void setCurrentHumidity(String currentHumidity)  {
        this.currentHumidity = currentHumidity;
    }
    public void setCurrentLight(String currentLight)    {
        this.currentLight = currentLight;

    }
    public void setCurrentOther(String currentOther)    {
        this.currentOther = currentOther;
    }

    //getter for the plant array
    public ArrayList<Plant> getPlants(){
        return plants;
    }
}
