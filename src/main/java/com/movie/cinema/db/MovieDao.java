/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author zhch
 */
public class MovieDao extends BaseDao{
    
    /**
     * 根据 id 获取电影信息
     * @param id
     * @return 
     */
    public Movie getMovie(int id){
        String sql = "select * from movies where id=?";
        ResultSetHandler<Movie> h = new BeanHandler<>(Movie.class);
        Movie res = (Movie)query(sql, h, id);
        return res;
    }
    /**
     * 获取所有的电影信息
     * @return 
     */
    public List<Movie> getMovies(){
        String sql = "select * from movies";
        ResultSetHandler<List<Movie>> h = new BeanListHandler<>(Movie.class);
        List<Movie> res = (List)query(sql, h);
        return res;
    }
    
    /**
     * 根据id 查询所有的电影信息
     * @param ids
     * @return 
     */
    public Map<Integer, Movie> getMoviesMap(List<Integer> ids){
        List<Movie> list = getMovies(ids);
        Map<Integer, Movie> map = new HashMap<>();
        list.forEach(c -> {
            map.put(c.getId(), c);
        });
        return map;
    }
    /**
     * 根据id 查询所有的电影信息
     * @param ids
     * @return 
     */
    public List<Movie> getMovies(List<Integer> ids){
        if(ids==null || ids.size() == 0){
            return new ArrayList<>();
        }
        String sql = "select * from movies where id in " + listToString(ids);
        ResultSetHandler<List<Movie>> h = new BeanListHandler<>(Movie.class);
        List<Movie> res = (List)query(sql, h);
        return res;
    }
    
    
    /**
     * 删除所有数据
     * @return 
     */
    public int deleteAll(){
        String sql = "delete from movies where id > -10";
        int res = update(sql);
        return res;
    }
    /** 
     * 插入一条数据
     * @param o
     * @return 
     */
    public int insertData(Movie o){
        String sql = "insert into movies (id, name, mtype, mtime,mdesc,image,publishtime) values(?,?,?,?,?,?,?)";
        int res = update(sql, o.getId(), o.getName(), o.getMtype(),o.getMtime(),o.getMdesc(), o.getImage(), o.getPublishtime());
        return res;
    }
}
