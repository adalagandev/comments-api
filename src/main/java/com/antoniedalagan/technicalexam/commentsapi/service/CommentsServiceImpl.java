package com.antoniedalagan.technicalexam.commentsapi.service;

import com.antoniedalagan.technicalexam.commentsapi.domain.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl implements CommentsService{
    @Override
    public void saveComment(Comment comment) {

    }

    @Override
    public Iterable<Comment> getComments() {
        return null;
    }

    @Override
    public void deleteComment(Comment comment) {

    }
}
