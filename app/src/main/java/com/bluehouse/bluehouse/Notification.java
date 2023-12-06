package com.bluehouse.bluehouse;

public class Notification {

private int id;
private String name, content;


public Notification(int id, String name, String content)    {
    this.id = id;
    this.name = name;
    this.content = content;
}

//getters


    public int getId()  {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getContent()  {
        return content;
    }

    //setters

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name)    {
        this.name = name;
    }
    public void setContent(String content)  {
        this.content = content;
    }






}
