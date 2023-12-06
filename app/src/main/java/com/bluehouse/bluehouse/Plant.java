package com.bluehouse.bluehouse;
import java.io.Serializable;
public class Plant implements Serializable{
    private String name;
    private String temp;
    private String humid;
    public Plant(String name, String temp, String humid){
        this.name = name;
        this.temp = temp;
        this.humid = humid;
    }
    public String getName(){
        return name;
    }
    public String getTemp(){
        return temp;
    }
    public String getHumid(){
        return humid;
    }
}
