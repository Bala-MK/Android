package com.example.hotelms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Availableroom extends AppCompatActivity {
    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RecyclerAdapter adapter;
    ArrayList<Room> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availableroom);
        rv=findViewById(R.id.rv);

        MyDatabase md=new MyDatabase(getApplicationContext());
        al=md.showValues(0);

        adapter=new RecyclerAdapter(this,al);
        lm=new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
}
