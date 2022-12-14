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
 * @author Hanpeng Jiang
 */
public class CinemaDao extends BaseDao{
    /**
     * Get all cinema information
     * @return 
     */
    public List<Cinema> getCinemas(){
        String sql = "select * from cinemas";
        ResultSetHandler<List<Cinema>> h = new BeanListHandler<>(Cinema.class);
        List<Cinema> res = (List)query(sql, h);
        return res;
    } 
    /**
     * Query all cinema information by ID
     * @param ids
     * @return 
     */
    public Map<Integer, Cinema> getCinemasMap(List<Integer> ids){
        List<Cinema> list = getCinemas(ids);
        Map<Integer, Cinema> map = new HashMap<>();
        list.forEach(c -> {
            map.put(c.getId(), c);
        });
        return map;
    }
    /**
     * Query all cinema information by ID
     * @param ids
     * @return 
     */
    public List<Cinema> getCinemas(List<Integer> ids){
        if(ids==null || ids.size() == 0){
            return new ArrayList<>();
        }
        String sql = "select * from cinemas where id in " + listToString(ids);
        ResultSetHandler<List<Cinema>> h = new BeanListHandler<>(Cinema.class);
        List<Cinema> res = (List)query(sql, h);
        return res;
    }
    
    
    /**
     * Delete all data
     * @return 
     */
    public int deleteAll(){
        String sql = "delete from cinemas where id > -10";
        int res = update(sql);
        return res;
    }
    /** 
     * Insert one data
     * @param o
     * @return 
     */
    public int insertData(Cinema o){
        String sql = "insert into cinemas (id, name, address) values(?,?,?)";
        int res = update(sql, o.getId(), o.getName(), o.getAddress());
        return res;
    }
}
