package com.example.prabodhaharankahadeniya.persistence;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;



@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void onClick(View view){
        if(view.getId()==R.id.btn_settings){
            Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent);

        }else  if(view.getId()==R.id.btn_create_user){
            Intent intent=new Intent(MainActivity.this,CreateUserActivity.class);
            startActivity(intent);

        }else if(view.getId()==R.id.btn_view_user){
            Intent intent=new Intent(MainActivity.this,ViewUsersActivity.class);
            startActivity(intent);

        }else if(view.getId()==R.id.btn_file_save){
            Intent intent=new Intent(MainActivity.this,FileSaveActivity.class);
            startActivity(intent);

        }

    }

}
