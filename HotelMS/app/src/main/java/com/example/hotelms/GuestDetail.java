package com.example.hotelms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class GuestDetail extends AppCompatActivity {

    ListView lv;
    Myadapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_detail);
        lv=findViewById(R.id.listview);
        MyDatabase3 md=new MyDatabase3(getApplicationContext());
        ArrayList<Guest> al=md.showGuestValues();
        ad=new Myadapter(this,al);
        lv.setAdapter(ad);
    }
}
