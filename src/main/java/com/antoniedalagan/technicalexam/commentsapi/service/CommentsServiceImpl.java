package com.antoniedalagan.technicalexam.commentsapi.service;

import com.antoniedalagan.technicalexam.commentsapi.domain.Comment;
import com.antoniedalagan.technicalexam.commentsapi.persistence.CommentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentsServiceImpl implements CommentsService{
    private static final Logger LOG = LoggerFactory.getLogger(CommentsServiceImpl.class);
    @Autowired
    CommentsRepository commentsRepository;

    @Override
    public void saveComment(Comment comment) {

    }

    @Override
    public Comment getComments() {
        return consolidateComments(6L);
    }

    private Comment consolidateComments(Long commentId){
        Map<Long,List<Comment>> mp = commentsRepository.getComment1123(commentId);
        Comment retComment =  mp.get(1L).get(0);
        for(Long c = 1L; c <= mp.size(); c++){ // loop for levels (max 4 roundtrips)
            List<Comment> parentLs = mp.get(c);
            if(c==mp.size()){
                break;
            }
            for(Comment pComment: parentLs){ // loop for parents
                for(Comment cComment: mp.get(c+1)){ // loop for children
                    if(pComment.getCommentId() == cComment.getParentCommentId()){
                        pComment.getSubComments().add(cComment);
                    }

                }
            }
        }






        return retComment;
    }

//    private void parse (Map<Comment, Map<Comment, Map>> mp, List<Comment> comments{
//
//    }

    @Override
    public void deleteComment(Comment comment) {
        LOG.error("\n\n getComments: "+commentsRepository.getAllComments());
        commentsRepository.deleteComment(comment.getCommentId());
    }
}
