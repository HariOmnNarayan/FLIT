package com.example.flit_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper( Context context) {
        super(context,"login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create table users(username text primary key,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists user");

    }
    public Boolean insertData(String username,String password){
        SQLiteDatabase myDB= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = myDB.insert("users",null,contentValues);

        if (result==-1){
            return false;
        }
        else {
            return true;

        }
    }
    public  Boolean checkusername(String username)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from users where username= ?",new String[]{username});
        if (cursor.getCount()>0)
        {
            return true;

        }
        else
        {
            return  false;
        }
    }
    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from users where username= ? and password= ? ",new String[]{username,password});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}


