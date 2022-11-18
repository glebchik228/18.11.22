package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Theme {
    public String name;
    public int id;
    public String text;
    public List<Comment> comments = new ArrayList<Comment>();

    public Theme(){}

    public Theme(String name, String text){
        this.name = name;
        this.text = text;
        id = new Random().nextInt();
    }

    public String getName(){
        return name;
    }
    public String getText(){
        return text;
    }
    public int getId(){
        return id;
    }
    public List<Comment> getComments(){
        return comments;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setText(String text){
        this.text = text;
    }

    public void clearThemeOfUserComment(User user){
        for (int i = 0; i < comments.size(); i++){
            if (comments.get(i).getUser().getMyCommentInTheme(this) == comments.get(i))
                comments.get(i).clearMe();
        }
    }
    public void clearThemeOfComments(){
        for (int i = 0; i < comments.size(); i++){
            comments.get(i).clearMe();
        }
    }
    public void addInComments(Comment comment){
        comments.add(comment);
    }
    public void removeOutComment(Comment comment){
        comments.remove(comment);
    }


}
