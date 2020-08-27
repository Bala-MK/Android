package com.example.hotelms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Createroom extends AppCompatActivity {
    EditText name,no,size,beds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createroom);
        name=findViewById(R.id.ed1);
        no=findViewById(R.id.ed2);
        size=findViewById(R.id.ed3);
        beds=findViewById(R.id.ed4);
    }

    public void create(View view){
        MyDatabase md=new MyDatabase(getApplicationContext());
        md.insert(0,name.getText().toString(),no.getText().toString(),Integer.parseInt(size.getText().toString()),Integer.parseInt(beds.getText().toString()));
        finish();
    }
}
