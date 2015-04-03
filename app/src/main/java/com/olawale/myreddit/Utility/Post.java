package com.olawale.myreddit.Utility;

public class Post {
	String subreddit;
    public String title;
    String author;
    int points;
    int numComments;
    String permalink;
    String url;   
    String domain;
    String id;
     
    public String getDetails(){
        String details=author
                       +" posted this and got "
                       +numComments
                       +" replies";
        return details;   
    }
     
    String getTitle(){
        return title;
    }
     
    public String getScore(){
        return Integer.toString(points);
    }

}
