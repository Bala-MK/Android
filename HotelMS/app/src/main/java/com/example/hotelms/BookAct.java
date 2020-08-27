package com.example.hotelms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BookAct extends AppCompatActivity {

    EditText name,mob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        name=findViewById(R.id.name);
        mob=findViewById(R.id.mobile);
    }

    public void book(View view){
        MyDatabase3 md=new MyDatabase3(getApplicationContext());
        md.insertguest(name.getText().toString(),Long.parseLong(mob.getText().toString()));
        finish();
    }
}
