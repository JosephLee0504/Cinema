/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Order;
import java.util.List;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Jiacheng Lv
 */
public class OrderDao extends BaseDao{
    /**
     * Find all booking records based on the row ID
     * @param scheduleid
     * @return 
     */
    public List<Order> getOrders(int scheduleid){
        String sql = "select * from orders where scheduleid=?";
        ResultSetHandler<List<Order>> h = new BeanListHandler<>(Order.class);
        List<Order> res = (List)query(sql, h, scheduleid);
        return res;
    }
    /**
     * Create a new booking record
     * @param order
     * @return 
     */
    public int addOrder(Order order){
        String sql = "insert into orders(scheduleid,accountid,seat, status)values(?,?,?,?)";
        int res = update(sql, order.getScheduleid(), order.getAccountid(), order.getSeat(), order.getStatus());
        return res;
    }
    /**
     * Update booking record status
     * @param order
     * @return 
     */
    public int updateStatus(Order order){
        String sql = "update orders set status = ? where id=?";
        int res = update(sql, order.getStatus(), order.getId());
        return res;
    }
    /**
     * Deletes the specified booking record
     * @param id
     * @return 
     */
    public int deleteOrder(int id){
        String sql = "delete from orders where id=?";
        int res = update(sql, id);
        return res;
    }
    /**
     * Gets the user's booking information
     * @param accid
     * @return 
     */
    public List<Order> getAccountOrders(int accid){
        String sql = "select * from orders where accountid=?";
        ResultSetHandler<List<Order>> h = new BeanListHandler<>(Order.class);
        List<Order> res = (List)query(sql, h, accid);
        return res;
    }
    
    
    /**
     * Delete all data
     * @return 
     */
    public int deleteAll(){
        String sql = "delete from orders where id > -10";
        int res = update(sql);
        return res;
    }
    /** 
     * insert one data
     * @param o
     * @return 
     */
    public int insertData(Order o){
        String sql = "insert into orders (id, scheduleid, accountid,seat,status) values(?,?,?,?,?)";
        int res = update(sql, o.getId(), o.getScheduleid(),o.getAccountid(),o.getSeat(),o.getStatus());
        return res;
    }
}
