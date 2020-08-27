package com.example.hotelms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    private static String dbname="my_database";
    private static int dbversion=1;
    //String s[]={"room","book","guest"};
    String s[]={"room"};
    Context ct;

    MyDatabase(Context ct){
        super(ct,dbname,null,dbversion);
        this.ct=ct;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String s1="create table room(name text,num text,size integer,beds integer)";
        /*String s2="create table book(name text,num text,size integer,beds integer)";
        String s3="create table guest(name text,mob integer)";*/
        sqLiteDatabase.execSQL(s1);
        /*sqLiteDatabase.execSQL(s2);
        sqLiteDatabase.execSQL(s3);*/
    }

    public void insert(int i, String name, String no, int size, int beds){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("num",no);
        cv.put("size",size);
        cv.put("beds",beds);
        db.insert(s[i],null,cv);
    }

    public ArrayList<Room> showValues(int in){
        SQLiteDatabase db=getReadableDatabase();
        String s0="select * from "+s[in];
        Cursor cr=db.rawQuery(s0,null);

        ArrayList<Room> al=new ArrayList<>();
        while(cr.moveToNext()){
            String s1=cr.getString(0);
            String s2=cr.getString(1);
            int i=cr.getInt(2);
            int j=cr.getInt(3);
            int image=R.drawable.ic_home_black_24dp;
            Room r=new Room(s1,s2,i,j,image);
            al.add(r);
        }
        return al;
    }

    public void delete(int i,String s1){
        SQLiteDatabase db=getWritableDatabase();
        String where="num=?";
        String[] s2={s1};
        db.delete(s[i],where,s2);
    }

    /*public void insertBook(String name, String no, int size, int beds){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("num",no);
        cv.put("size",size);
        cv.put("beds",beds);
        db.insert("book",null,cv);
        Toast.makeText(ct, "inserted:", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<Room> showBookValues(){
        SQLiteDatabase db=getReadableDatabase();
        String s="select * from book";
        Cursor cr=db.rawQuery(s,null);
        ArrayList<Room> al=new ArrayList<>();
        while(cr.moveToNext()){
            String s1=cr.getString(0);
            String s2=cr.getString(1);
            int i=cr.getInt(2);
            int j=cr.getInt(3);
            int image=R.drawable.ic_home_black_24dp;
            Room r=new Room(s1,s2,i,j,image);
            al.add(r);
        }
        return al;
    }
    public void insertguest(String s1,long i){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",s1);
        cv.put("mob",i);
        db.insert("guest",null,cv);
        Toast.makeText(ct, "inserted", Toast.LENGTH_SHORT).show();
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
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
