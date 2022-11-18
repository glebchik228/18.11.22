package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String username;
    public List<Comment> myComments = new ArrayList<Comment>();

    public User (String username){
        this.username = username;
    }

    public List<Comment> getMyComments(){
        return myComments;
    }
    public Comment getMyCommentInTheme(Theme theme){
        for (int i = 0; i < myComments.size(); i++){
            if (myComments.get(i).getTheme() == theme)
                return myComments.get(i);
        }
        return null;
    }

    public String getUsername(){
        return username;
    }

    public void addInMyComments(Comment comment){
        myComments.add(comment);
    }

    public void removeOutMyComment(Comment comment){
        myComments.remove(comment);
    }

}
