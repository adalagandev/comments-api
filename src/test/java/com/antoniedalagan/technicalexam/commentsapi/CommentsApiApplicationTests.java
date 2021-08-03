package com.antoniedalagan.technicalexam.commentsapi;

import com.antoniedalagan.technicalexam.commentsapi.persistence.CommentsRepository;
import com.antoniedalagan.technicalexam.commentsapi.service.CommentsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommentsApiApplicationTests {

    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    CommentsService commentsService;

    @Test
    void contextLoads() {
        System.out.println(commentsRepository.getComment1123(6L));
        commentsService.getComments();
    }


}
