//package com.example.quotes.roomDB;
//
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.PrimaryKey;
//
//@Entity(tableName = "quotesDB")
//public class Entities {
//
//    public static class quotesDB {
//        @PrimaryKey(autoGenerate = true)
//        public int qid;
//
//        @ColumnInfo(name = "quotes")
//        public String quote;
//
//        @ColumnInfo(name = "category")
//        public String category;
//
//        @ColumnInfo(name = "liked")
//        public String liked;
//    }
//
//}
package com.example.quotes.roomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "quotesDB")
public class Entities {
    @PrimaryKey(autoGenerate = true)
    public int qid;

    @ColumnInfo(name = "quotes")
    public String quote;

    @ColumnInfo(name = "category")
    public String category;

    @ColumnInfo(name = "fav")
    public String fav;
}
