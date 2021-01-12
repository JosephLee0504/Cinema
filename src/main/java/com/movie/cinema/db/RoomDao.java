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
 * @author zhch
 */
public class RoomDao extends BaseDao{
    /**
     * 根据ID查找放映厅
     * @param id
     * @return 
     */
    public Room getRoomById(int id){
        String sql = "select * from rooms";
        ResultSetHandler<Room> h = new BeanHandler<Room>(Room.class);
        Room res = (Room)query(sql, h);
        return res;
    }
    /**
     * 查找所有放映厅
     * @param id
     * @return 
     */
    public List<Room> getRooms(){
        String sql = "select * from rooms";
        ResultSetHandler<List<Room>> h = new BeanListHandler<Room>(Room.class);
        List<Room> res = (List)query(sql, h);
        return res;
    }
}
