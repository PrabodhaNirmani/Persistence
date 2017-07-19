package com.example.prabodhaharankahadeniya.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by prabodhaharankahadeniya on 7/19/17.
 */

public class DBHandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "users.db";
    private static final String TABLE_NAME = "user";
    private static final int DATABASE_VERSION=1;
    private  Context context;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE user(id INTEGER AUTO INCREMENT, name TEXT, age TEXT, city TEXT)";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old_version, int new_version) {

    }

    public void addUser(User user){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",user.getName());
        values.put("age",user.getAge());
        values.put("city",user.getCity());
        db.insert(TABLE_NAME,null,values);
        db.close();

    }

    public void deleteUser(String id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete(TABLE_NAME,"id = ?",new String[]{ id });
        db.close();

    }

    public boolean updateUser(User user,String id){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",user.getName());
        values.put("age",user.getAge());
        values.put("city",user.getCity());
        long res=db.update(TABLE_NAME,values,"id = ?",new String[]{ id });
        db.close();
        if(res==-1){
            return false;
        }
        else {
            return true;
        }

    }


    public Cursor getAllUser(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM user",null);
        db.close();
        return cursor;
    }
}
