package com.example.hotelms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createRoom(View view){
        Intent i=new Intent(this,Createroom.class);
        startActivity(i);
    }

    public void availableRooms(View view){
        Intent i=new Intent(this,Availableroom.class);
        startActivity(i);
    }

    public void bookedRooms(View view){
        Intent i=new Intent(this,Bookedroom.class);
        startActivity(i);
    }

    public void guests(View view){
        Intent i=new Intent(this,GuestDetail.class);
        startActivity(i);
    }
}
