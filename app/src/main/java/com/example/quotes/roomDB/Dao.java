package com.example.quotes.roomDB;

import androidx.room.Query;

import com.example.quotes.Model;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Query("SELECT *FROM quotesDB")
    List<Model>getAll();
}
