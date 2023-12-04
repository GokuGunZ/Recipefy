package it.unipv.po.recipefy.Beans;

public class Category {
    int tagID;
    int userID;
    String categoryName;
    String tag;

    public Category(int tagID, int userID, String categoryName, String tag){
        this.categoryName = categoryName;
        this.tag = tag;
        this.tagID = tagID;
        this.userID = userID;
    }
    public String getCategoryName(){return this.categoryName;}
}
