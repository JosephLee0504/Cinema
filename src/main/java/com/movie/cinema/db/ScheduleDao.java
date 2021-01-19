/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Schedule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Shijie Ma
 */
public class ScheduleDao extends BaseDao{
    /**
     * Find the movie arrangement record by ID
     * @param id
     * @return 
     */
    public Schedule getSchedule(int id){
        String sql = "select * from schedules where id=?";
        ResultSetHandler<Schedule> h;
        h = new BeanHandler<>(Schedule.class);
        Schedule res = (Schedule)query(sql, h, id);
        return res;
    }
    /**
     * Query the movie arrangement information according to the movie ID
     * @param movieid
     * @return 
     */
    public List<Schedule> getSchedules(int movieid){
        String sql = "select * from schedules where movieid=?";
        ResultSetHandler<List<Schedule>> h = new BeanListHandler<>(Schedule.class);
        List<Schedule> res = (List)query(sql, h, movieid);
        return res;
    }
    
    /**
     * Query the movie arrangement information according to the movie ID
     * @param cinemaid
     * @return 
     */
    public List<Schedule> getCinemaSchedules(int cinemaid){
        String sql = "select * from schedules where cinemaid=?";
        ResultSetHandler<List<Schedule>> h = new BeanListHandler<>(Schedule.class);
        List<Schedule> res = (List)query(sql, h, cinemaid);
        return res;
    }
    
    
    /**
     * Query all the scheduling information by ID
     * @param ids
     * @return 
     */
    public Map<Integer, Schedule> getSchedulesMap(List<Integer> ids){
        List<Schedule> list = getSchedules(ids);
        Map<Integer, Schedule> map;
        map = new HashMap<>();
        list.forEach(c -> {
            map.put(c.getId(), c);
        });
        return map;
    }
    /**
     * Query all the scheduling information by ID
     * @param ids
     * @return 
     */
    public List<Schedule> getSchedules(List<Integer> ids){
        if(ids==null || ids.size() == 0){
            return new ArrayList<>();
        }
        String sql = "select * from schedules where id in " + listToString(ids);
        ResultSetHandler<List<Schedule>> h = new BeanListHandler<>(Schedule.class);
        List<Schedule> res = (List)query(sql, h);
        return res;
    }
}
