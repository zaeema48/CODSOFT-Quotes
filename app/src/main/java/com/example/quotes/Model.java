package com.example.quotes;

public class Model {
   private String quote;
    private String category;
    private  boolean fav;

    public Model(String quote, String category) {
        this.quote = quote;
        this.category = category;
        this.fav=false;
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
