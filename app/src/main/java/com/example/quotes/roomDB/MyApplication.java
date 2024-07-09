package com.example.quotes.roomDB;

import android.app.Application;

import androidx.room.Room;

public class MyApplication extends Application {
    //INSTANTIATING THE DATABASE
    public AppDB db;

    @Override
    public void onCreate() {
        super.onCreate();
        db= Room.databaseBuilder((getApplicationContext()), AppDB.class, "quotesDB").build(); 
    }

}
