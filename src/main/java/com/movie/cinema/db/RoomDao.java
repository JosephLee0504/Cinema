/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Room;
import java.util.List;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Jiacheng Lv
 */
public class RoomDao extends BaseDao{
    /**
     * Find the projection room by ID
     * @param id
     * @return 
     */
    public Room getRoomById(int id){
        String sql = "select * from rooms";
        ResultSetHandler<Room> h = new BeanHandler<>(Room.class);
        Room res = (Room)query(sql, h);
        return res;
    }
    /**
     * Find all the projection room
     * @return 
     */
    public List<Room> getRooms(){
        String sql = "select * from rooms";
        ResultSetHandler<List<Room>> h = new BeanListHandler<>(Room.class);
        List<Room> res = (List)query(sql, h);
        return res;
    }
    
    
    /**
     * Delete all data
     * @return 
     */
    public int deleteAll(){
        String sql = "delete from rooms where id > -10";
        int res = update(sql);
        return res;
    }
    /** 
     * Insert one data
     * @param o
     * @return 
     */
    public int insertData(Room o){
        String sql = "insert into rooms (id, name, cinemaid,seatcount) values(?,?,?,?)";
        int res = update(sql, o.getId(), o.getName(), o.getCinemaid(), o.getSeatcount());
        return res;
    }
}
