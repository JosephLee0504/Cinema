/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Comment;
import java.util.List;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Shijie Ma
 */
public class CommentDao extends BaseDao{
    /**
     * Add a comment
     * @param order
     * @return 
     */
    public int addComment(Comment order){
        String sql = "insert into comments(movieid,accountid,comment, publishtime)values(?,?,?,?)";
        int res = update(sql, order.getMovieid(), order.getAccountid(), order.getComment(), order.getPublishtime());
        return res;
    }
    /**
     * View reviews based on MovieID
     * @param movieid
     * @return 
     */
    public List<Comment> getComments(int movieid){
        String sql = "select * from comments where movieid=?";
        ResultSetHandler<List<Comment>> h = new BeanListHandler<>(Comment.class);
        List<Comment> res = (List)query(sql, h, movieid);
        return res;
    }
}
