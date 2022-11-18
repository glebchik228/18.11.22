package com.example.demo;

public class Comment {
    public User user;
    public Theme theme;

    public String textOfComment;

    public Comment(User user, Theme theme, String textOfComment){
        this.user = user;
        this.theme = theme;
        this.textOfComment = textOfComment;

        user.addInMyComments(this);
        theme.addInComments(this);
    }

    public User getUser(){
        return user;
    }
    public Theme getTheme(){
        return theme;
    }
    public String getTextOfComment(){
        return textOfComment;
    }

    public void clearMe(){
        user.removeOutMyComment(this);
        theme.removeOutComment(this);
    }
    public void setTextOfComment(String textOfComment){
        this.textOfComment = textOfComment;
    }
}
