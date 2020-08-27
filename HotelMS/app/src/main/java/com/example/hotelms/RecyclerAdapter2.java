package com.example.hotelms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.MyViewHolder> {
    Context ct;
    ArrayList<Room> roomAl;
    public RecyclerAdapter2(Context ct, ArrayList<Room> roomAl) {
        this.ct=ct;
        this.roomAl=roomAl;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(ct);
        View v=li.inflate(R.layout.recyclerlayout2,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Room r=roomAl.get(position);
        holder.tvname.setText(r.getName());
        holder.tvnumber.setText(r.getNumber());
        holder.tvsize.setText(""+r.getSize());
        holder.tvbeds.setText(""+r.getNoofbeds());
        holder.iv.setImageResource(r.getImage());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabase2 md2=new MyDatabase2(ct);
                md2.delete(""+r.getNumber());
                MyDatabase md=new MyDatabase(ct);
                md.insert(0,r.getName(),r.getNumber(),r.getSize(),r.getNoofbeds());
                Toast.makeText(ct, "Added to Available Rooms", Toast.LENGTH_SHORT).show();
                Activity a=(Activity) ct;
                a.recreate();
            }
        });
    }

    @Override
    public int getItemCount() {
        return roomAl.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvnumber,tvbeds,tvsize;
        ImageView iv;
        LinearLayout layout;
        Button delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.roomnamerl2);
            tvnumber=itemView.findViewById(R.id.roomnumberrl2);
            tvsize=itemView.findViewById(R.id.roomsizerl2);
            tvbeds=itemView.findViewById(R.id.noofbedsrl2);
            iv=itemView.findViewById(R.id.roomivrl2);
            layout=itemView.findViewById(R.id.ll2);
            delete=itemView.findViewById(R.id.delbtnrl2);
        }
    }
}
