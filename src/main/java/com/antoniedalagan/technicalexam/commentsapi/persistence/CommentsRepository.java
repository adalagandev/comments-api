package com.antoniedalagan.technicalexam.commentsapi.persistence;

import com.antoniedalagan.technicalexam.commentsapi.domain.Comment;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class CommentsRepository {



    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String  GET_COMMENTS_FOR_COMMENT_ID =
            " WITH COMMENTS_HIE (COMMENT_ID, USER, TEXT, PARENT_COMMENT_ID, LEVEL) AS " +
            " ( " +
            " SELECT   CC.COMMENT_ID, CC.USER, CC.TEXT, CC.PARENT_COMMENT_ID, 1 as LEVEL  FROM COMMENTS CC WHERE COMMENT_ID = :commentId " +
            " UNION ALL " +
            " SELECT   CM.COMMENT_ID,  CM.USER, CM.TEXT,  CM.PARENT_COMMENT_ID,  CH.LEVEL +1  FROM COMMENTS_HIE  CH INNER JOIN COMMENTS CM ON   CM.PARENT_COMMENT_ID  =CH.COMMENT_ID " +
            " )  SELECT * FROM COMMENTS_HIE   CMH " ;

    private static final String DELETE_COMMENTS_FOR_COMMENT_ID =
            " delete from COMMENTS  cm1 where cm1.comment_id in (\n" +
                    " select COMMENT_ID from (  "+ GET_COMMENTS_FOR_COMMENT_ID + " ))";


    public List<Comment> getComments(Long commentId){
        return namedParameterJdbcTemplate.query(GET_COMMENTS_FOR_COMMENT_ID, new MapSqlParameterSource("commentId",commentId), BeanPropertyRowMapper.newInstance(Comment.class));
    }

    public Map<Long,List<Comment>> getComment1123(Long commentId){
        return namedParameterJdbcTemplate.query(
                GET_COMMENTS_FOR_COMMENT_ID,
                new MapSqlParameterSource("commentId",commentId),
                new ResultSetExtractor<Map<Long,List<Comment>>>(){
                    public Map<Long,List<Comment>> extractData(ResultSet rs) throws SQLException, DataAccessException {
                        BeanPropertyRowMapper<Comment> commentRowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
                        Map<Long,List<Comment>> levelsMap = new HashMap<>();

                        while(rs.next()){
                            Comment comment = commentRowMapper.mapRow(rs, rs.getRow());
                            if(levelsMap.containsKey(comment.getLevel())){
                                levelsMap.get(comment.getLevel()).add(comment);
                            }else{
                                levelsMap.put(comment.getLevel(), new ArrayList<>(Arrays.asList(comment)));
                            }
                        }

                        return levelsMap;
                    }
                });
    }

    public List<Comment> getAllComments(){
      return null;
    }

    public void deleteComment(Long commentId){
        namedParameterJdbcTemplate.update(DELETE_COMMENTS_FOR_COMMENT_ID, new MapSqlParameterSource("commentId",commentId));
    }


}
