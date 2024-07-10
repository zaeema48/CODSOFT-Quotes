package com.example.quotes;

public class Model {
    private int qid;
   private String quote;
    private String category;
    private  boolean fav;

    public Model(int qid, String quote, String category) {
        this.qid = qid;
        this.quote = quote;
        this.category = category;
        this.fav=false;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
