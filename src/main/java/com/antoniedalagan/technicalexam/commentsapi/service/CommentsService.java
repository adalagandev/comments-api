package com.antoniedalagan.technicalexam.commentsapi.service;

import com.antoniedalagan.technicalexam.commentsapi.domain.Comment;

import java.util.List;

public interface CommentsService {

    void saveComment(Comment comment);
    Comment getComments();
    void deleteComment(Comment comment);


}
