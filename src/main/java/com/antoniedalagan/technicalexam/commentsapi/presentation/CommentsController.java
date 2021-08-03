package com.antoniedalagan.technicalexam.commentsapi.presentation;


import com.antoniedalagan.technicalexam.commentsapi.domain.Comment;
import com.antoniedalagan.technicalexam.commentsapi.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @GetMapping( value = {"", "/"})
    public Comment getComments(){
        return commentsService.getComments();
    }
}
