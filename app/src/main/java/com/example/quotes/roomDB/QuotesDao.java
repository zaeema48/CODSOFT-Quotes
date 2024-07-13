package com.example.quotes.roomDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface QuotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Quote quote);

    @Query("SELECT * FROM quote ORDER BY qid DESC")
    List<Quote>getAll();

    @Query("SELECT * FROM quote ORDER BY RANDOM() LIMIT 10")
    List<Quote> getRandom();

    @Query("SELECT * FROM quote WHERE quotes LIKE :searchQuery")
    List<Quote> searchQuote(String searchQuery);

    @Query("SELECT * FROM quote WHERE category =:query")
    List<Quote> selectCategory(String query);

    @Query("UPDATE quote SET liked =1 WHERE qid =:id")
    void addToFav(int id);

    @Query("UPDATE quote SET liked =0 WHERE qid =:id")
    void removeFav(int id);

    @Query("SELECT * FROM quote WHERE liked = 1")
    List<Quote> favList();

}
