package com.antoniedalagan.technicalexam.commentsapi.service;

import com.antoniedalagan.technicalexam.commentsapi.domain.Comment;

public interface CommentsService {

    void saveComment(Comment comment);
    Iterable<Comment> getComments();
    void deleteComment(Comment comment);


}
