package com.example.hotelms;

public class Room {
    String name;
    String number;
    int size;
    int noofbeds;
    int image;

    public Room(String name, String number, int size, int noofbeds, int image){
        this.name=name;
        this.number=number;
        this.size=size;
        this.noofbeds=noofbeds;
        this.image=image;
    }

    public String getName(){
        return name;
    }
    public String getNumber(){
        return number;
    }
    public int getSize(){
        return size;
    }
    public int getNoofbeds(){
        return noofbeds;
    }
    public int getImage(){
        return image;
    }
}
