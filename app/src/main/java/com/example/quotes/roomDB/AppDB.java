package com.example.quotes.roomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={Quote.class}, version=1)
public abstract class AppDB extends RoomDatabase {
    private static AppDB database;
    private static String databaseName="QuoteDB";

    //creating the database
    public synchronized static AppDB
    getInstance(Context context){
        if(database==null){
            database= Room.databaseBuilder(context.getApplicationContext(),
                            AppDB.class,databaseName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    public abstract QuotesDao quotesdao();
}
