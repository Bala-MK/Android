package com.example.hotelms;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Myadapter extends BaseAdapter {
    Context ct;
    ArrayList<Guest> al;

    Myadapter(Context ct,ArrayList<Guest> al){
        this.ct=ct;
        this.al=al;
    }
    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int i) {
        return al.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Guest g=(Guest)getItem(i);
        Activity at=(Activity) ct;
        View v=at.getLayoutInflater().inflate(R.layout.mylayout,null);

        TextView tv1=v.findViewById(R.id.myname);
        TextView tv2=v.findViewById(R.id.mymob);
        ImageView iv=v.findViewById(R.id.myiv);

        iv.setImageResource(R.drawable.ic_person_black_24dp);
        tv1.setText(g.getName());
        tv2.setText(""+g.getMob());
        return v;
    }
}
