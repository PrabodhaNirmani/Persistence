package com.example.prabodhaharankahadeniya.persistence;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_file_save)
public class FileSaveActivity extends RoboActivity {

    @InjectView(R.id.file_content) private EditText fileContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        try{
            String alreadyText=_readFromFile();
            fileContent.setText(alreadyText);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void saveData(View view){
        try {
            _writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finish();


    }

    public void resetFile(View view){

        try {
            String FILE_NAME="hello_file";
            FileOutputStream fos=openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write("".getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finish();

    }

    private String _readFromFile() throws IOException {
        String FILE_NAME="hello_file";
        FileInputStream fis=openFileInput(FILE_NAME);
        StringBuffer fileData=new StringBuffer("");
        byte[] buffer=new byte[1024];
        int n;
        while((n = fis.read(buffer))!= -1){
            fileData.append(new String(buffer,0,n));
        }

        return fileData.toString();


    }


    private void _writeToFile() throws IOException {

        String FILE_NAME="hello_file";
        String string="hello world!";

        FileOutputStream fos=openFileOutput(FILE_NAME, Context.MODE_APPEND);
        fos.write(string.getBytes());
        fos.close();
    }
}
