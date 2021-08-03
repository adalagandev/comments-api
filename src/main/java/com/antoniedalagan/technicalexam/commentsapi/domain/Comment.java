package com.antoniedalagan.technicalexam.commentsapi.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comment {

    private Long commentId;


    private String text;
    private String user;
    private Long level;
    private Long parentCommentId;
    private List<Comment> subComments = new ArrayList<>();


    public Comment (){

    }
    public Comment (Long parentCommentId, String text, String user){
        this.parentCommentId = parentCommentId;
        this.text = text;
        this.user = user;
    }
    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Comment> getSubComments() {
        return subComments;
    }

    public void setSubComments(List<Comment> subComments) {
        this.subComments = subComments;
    }

    @Override
    public String toString() {
        return "\n Comment{" +
                "commentId=" + commentId +
                ", text='" + text + '\'' +
                ", user='" + user + '\'' +
                ", level=" + level +
                ", parentCommentId=" + parentCommentId +
                ", subComments=" + subComments +
                '}';
    }


}
