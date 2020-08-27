package com.example.hotelms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDatabase3 extends SQLiteOpenHelper {
    private static String dbname="my_database3";
    private static int dbversion=1;
    Context ct;

    MyDatabase3(Context ct){
        super(ct,dbname,null,dbversion);
        this.ct=ct;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String s3="create table guest(name text,mob integer)";
        sqLiteDatabase.execSQL(s3);
    }

    public void insertguest(String s1,long i){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",s1);
        cv.put("mob",i);
        db.insert("guest",null,cv);
    }

    public ArrayList<Guest> showGuestValues(){
        SQLiteDatabase db=getReadableDatabase();
        String s0="select * from guest";
        Cursor cr=db.rawQuery(s0,null);

        ArrayList<Guest> al=new ArrayList<>();
        while(cr.moveToNext()){
            String s1=cr.getString(0);
            long l=cr.getLong(1);
            Guest g=new Guest(s1,l);
            al.add(g);
        }
        return al;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
