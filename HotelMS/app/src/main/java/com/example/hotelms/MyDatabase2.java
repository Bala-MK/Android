package com.example.hotelms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDatabase2 extends SQLiteOpenHelper {

    private static String dbname="my_database2";
    private static int dbversion=1;
    Context ct;

    MyDatabase2(Context ct){
        super(ct,dbname,null,dbversion);
        this.ct=ct;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String s2="create table book(name text,num text,size integer,beds integer)";
        sqLiteDatabase.execSQL(s2);
    }

    public void insertBook(String name, String no, int size, int beds){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("num",no);
        cv.put("size",size);
        cv.put("beds",beds);
        db.insert("book",null,cv);
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
    public void delete(String s1){
        SQLiteDatabase db=getWritableDatabase();
        String where="num=?";
        String[] s2={s1};
        db.delete("book",where,s2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
