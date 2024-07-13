package com.example.quotes.roomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "quote")
public class Quote implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int qid=0;

    @ColumnInfo(name = "quotes")
    private String quote="";

    @ColumnInfo(name = "category")
    private String category="";

    @ColumnInfo(name = "liked")
    private boolean liked=false;

    public Quote() {
    }

    public Quote(String quote, String category) {
        this.quote = quote;
        this.category = category;
    }

    public int getQid() {
        return qid;
    }

    public String getQuote() {
        return quote;
    }

    public String getCategory() {
        return category;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
