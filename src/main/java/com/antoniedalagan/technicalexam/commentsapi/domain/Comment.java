package com.antoniedalagan.technicalexam.commentsapi.domain;

public class Comment {

    private Long commentId;
    private Comment parentComment;
    private String text;
    private String user;

    public Comment (){

    }
    public Comment (Comment parentComment, String text, String user){
        this.parentComment = parentComment;
        this.text = text;
        this.user = user;

    }
}
