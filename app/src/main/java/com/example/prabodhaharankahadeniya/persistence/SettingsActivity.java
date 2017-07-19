package com.example.prabodhaharankahadeniya.persistence;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_settings)
public class SettingsActivity extends RoboActivity {

    private static final String KEY_CHECK_FOR_UPDATE="chk-for-update";
    private static final String KEY_URL="key-url";

    @InjectView(R.id.txtUrl) private EditText textURL;
    @InjectView(R.id.checkbox) private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref=getSharedPreferences("com.prabodha.persistence.settings",Context.MODE_PRIVATE);
        boolean userDataAlreadySaved=pref.getBoolean(KEY_CHECK_FOR_UPDATE,false);
        String url=pref.getString(KEY_URL,"None");
        textURL.setText(url);
        checkBox.setChecked(userDataAlreadySaved);
    }


    public void saveSettings(View view){
        SharedPreferences preferences=getSharedPreferences("com.prabodha.persistence.settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();


        editor.putBoolean(KEY_CHECK_FOR_UPDATE,checkBox.isChecked());
        editor.putString(KEY_URL,textURL.getText().toString());
        editor.commit();

        Toast.makeText(this,"changes saved to shared preferences",Toast.LENGTH_LONG).show();

        finish();
    }
}
