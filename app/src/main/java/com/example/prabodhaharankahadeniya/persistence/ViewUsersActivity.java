package com.example.prabodhaharankahadeniya.persistence;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_view_users)
public class ViewUsersActivity extends RoboActivity {


    private static final String TAG="ViewUserActivity";
    private DBHandler dbHandler;
    public  DBHandler getDBHandler(){
        if(dbHandler==null){
            dbHandler=new DBHandler(this);
        }
        return dbHandler;
    }

    private User[] users;
    @InjectView(R.id.list_view) private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        users=getDBHandler().getAllUser();
        Log.d(TAG," "+users.length);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return users.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View convertView, ViewGroup viewGroup) {
                User user=users[i];
                View cellUser=null;
                if(convertView==null){
                    cellUser= LayoutInflater.from(ViewUsersActivity.this).inflate(R.layout.user_list_item,null);

                }
                else {
                    cellUser=convertView;
                }

                PlaceHolder ph=(PlaceHolder)cellUser.getTag();
                TextView nameTV;
                TextView ageTV;
                TextView cityTV;

                if(ph==null){
                    nameTV=cellUser.findViewById(R.id.name);
                    ageTV= cellUser.findViewById(R.id.age);
                    cityTV=cellUser.findViewById(R.id.city);


                    ph=new PlaceHolder();
                    ph.name=nameTV;
                    ph.age=ageTV;
                    ph.city=cityTV;
                    cellUser.setTag(ph);

                }
                else {
                    nameTV=ph.name;
                    ageTV=ph.age;
                    cityTV=ph.city;

                }


                nameTV.setText(user.getName());
                ageTV.setText(user.getAge());
                cityTV.setText(user.getCity());


                return cellUser;
            }
        });

    }

    private class PlaceHolder{
        TextView name;
        TextView age;
        TextView city;
    }
}
