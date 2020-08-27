package com.example.hotelms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Bookedroom extends AppCompatActivity {
    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RecyclerAdapter2 ad;
    ArrayList<Room> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookedroom);
        rv=findViewById(R.id.bookrv);

        MyDatabase2 md=new MyDatabase2(getApplicationContext());
        al=md.showBookValues();
        ad=new RecyclerAdapter2(this,al);
        lm=new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(ad);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
}
