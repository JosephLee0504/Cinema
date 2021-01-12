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
        ResultSetHandler<Movie> h = new BeanHandler<Movie>(Movie.class);
        Movie res = (Movie)query(sql, h, id);
        return res;
    }
    /**
     * 获取所有的电影信息
     * @return 
     */
    public List<Movie> getMovies(){
        String sql = "select * from movies";
        ResultSetHandler<List<Movie>> h = new BeanListHandler<Movie>(Movie.class);
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
        for(Movie c : list){
            map.put(c.getId(), c);
        }
        return map;
    }
    /**
     * 根据id 查询所有的电影信息
     * @param ids
     * @return 
     */
    public List<Movie> getMovies(List<Integer> ids){
        if(ids==null || ids.size() == 0){
            return new ArrayList<Movie>();
        }
        String sql = "select * from movies where id in " + listToString(ids);
        ResultSetHandler<List<Movie>> h = new BeanListHandler<Movie>(Movie.class);
        List<Movie> res = (List)query(sql, h);
        return res;
    }
}
