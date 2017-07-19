package com.example.prabodhaharankahadeniya.persistence;


import android.os.Bundle;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;

@ContentView(R.layout.activity_view_users)
public class ViewUsersActivity extends RoboActivity {


    private DBHandler dbHandler;
    public  DBHandler getDBHandler(){
        if(dbHandler==null){
            dbHandler=new DBHandler(this);
        }
        return dbHandler;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
