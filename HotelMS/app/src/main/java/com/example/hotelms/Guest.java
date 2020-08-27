package com.example.hotelms;

public class Guest {
    String name;
    long mob;
    public Guest(String name,long mob){
        this.name=name;
        this.mob=mob;
    }
    public String getName(){
        return name;
    }
    public long getMob(){
        return mob;
    }
}
