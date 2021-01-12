/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Account;
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
 * @author zhch
 */
public class ScheduleDao extends BaseDao{
    /**
     * 根据影片ID查询影片的排片信息
     * @param movieid
     * @return 
     */
    public List<Schedule> getSchedules(int movieid){
        String sql = "select * from schedules where movieid=?";
        ResultSetHandler<List<Schedule>> h = new BeanListHandler<Schedule>(Schedule.class);
        List<Schedule> res = (List)query(sql, h, movieid);
        return res;
    }
    
    
    /**
     * 根据id 查询所有的排片信息
     * @param ids
     * @return 
     */
    public Map<Integer, Schedule> getSchedulesMap(List<Integer> ids){
        List<Schedule> list = getSchedules(ids);
        Map<Integer, Schedule> map = new HashMap<>();
        for(Schedule c : list){
            map.put(c.getId(), c);
        }
        return map;
    }
    /**
     * 根据id 查询所有的排片信息
     * @param ids
     * @return 
     */
    public List<Schedule> getSchedules(List<Integer> ids){
        if(ids==null || ids.size() == 0){
            return new ArrayList<Schedule>();
        }
        String sql = "select * from schedules where id in " + listToString(ids);
        ResultSetHandler<List<Schedule>> h = new BeanListHandler<Schedule>(Schedule.class);
        List<Schedule> res = (List)query(sql, h);
        return res;
    }
}
