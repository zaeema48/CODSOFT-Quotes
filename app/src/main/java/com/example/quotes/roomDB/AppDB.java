package com.example.quotes.roomDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities={Entities.class}, version=1)
public abstract class AppDB extends RoomDatabase {
    public abstract Dao dao();

}
