package com.antoniedalagan.technicalexam.commentsapi.presentation;


import com.antoniedalagan.technicalexam.commentsapi.domain.Comment;
import com.antoniedalagan.technicalexam.commentsapi.service.CommentsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    private CommentsService commentsService;

    @GetMapping()
    public Iterable<Comment> getComments(){
        return commentsService.getComments();
    }
}
