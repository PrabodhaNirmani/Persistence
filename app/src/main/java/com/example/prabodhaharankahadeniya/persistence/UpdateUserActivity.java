package com.example.prabodhaharankahadeniya.persistence;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Created by prabodhaharankahadeniya on 7/20/17.
 */
@ContentView(R.layout.activity_update_user)
public class UpdateUserActivity extends RoboActivity {
    @InjectView(R.id.name) private EditText txt_name;
    @InjectView(R.id.age) private EditText txt_age;

    @InjectView(R.id.city) private EditText txt_city;
    private static final String TAG="UpdateUserActivity";

    private User user;
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
        Bundle bundle=getIntent().getExtras();
        user=new User();
        user.setId(bundle.getString("id"));
        user.setName(bundle.getString("name"));
        user.setAge(bundle.getString("age"));
        user.setCity(bundle.getString("city"));
        txt_name.setText(user.getName());
        txt_age.setText(user.getAge());
        txt_city.setText(user.getCity());

    }

    public void updateUser(View view){

        String name=txt_name.getText().toString();
        String age=txt_age.getText().toString();
        String city=txt_city.getText().toString();
        getDBHandler().updateUser(new User(name,age,city),user.getId());

        Intent intent = new Intent(this, ViewUsersActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();


    }
}
