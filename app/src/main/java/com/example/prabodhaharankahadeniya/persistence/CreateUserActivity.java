package com.example.prabodhaharankahadeniya.persistence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_create_user)
public class CreateUserActivity extends RoboActivity {

    @InjectView(R.id.name) private EditText txt_name;
    @InjectView(R.id.age) private EditText txt_age;

    @InjectView(R.id.city) private EditText txt_city;

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

    public void createUser(View view){

        String name=txt_name.getText().toString();
        String age=txt_age.getText().toString();
        String city=txt_city.getText().toString();
        getDBHandler().addUser(new User(name,age,city));

        Intent intent = new Intent(this, ViewUsersActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();


    }
}
