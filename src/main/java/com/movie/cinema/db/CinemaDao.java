/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Cinema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author zhch
 */
public class CinemaDao extends BaseDao{
    /**
     * 获取所有影院信息
     * @return 
     */
    public List<Cinema> getCinemas(){
        String sql = "select * from cinemas";
        ResultSetHandler<List<Cinema>> h = new BeanListHandler<Cinema>(Cinema.class);
        List<Cinema> res = (List)query(sql, h);
        return res;
    } 
    /**
     * 根据id 查询所有的影院信息
     * @param ids
     * @return 
     */
    public Map<Integer, Cinema> getCinemasMap(List<Integer> ids){
        List<Cinema> list = getCinemas(ids);
        Map<Integer, Cinema> map = new HashMap<>();
        for(Cinema c : list){
            map.put(c.getId(), c);
        }
        return map;
    }
    /**
     * 根据id 查询所有的影院信息
     * @param ids
     * @return 
     */
    public List<Cinema> getCinemas(List<Integer> ids){
        if(ids==null || ids.size() == 0){
            return new ArrayList<Cinema>();
        }
        String sql = "select * from cinemas where id in " + listToString(ids);
        ResultSetHandler<List<Cinema>> h = new BeanListHandler<Cinema>(Cinema.class);
        List<Cinema> res = (List)query(sql, h);
        return res;
    }
}