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
 * @author zhch
 */
public class OrderDao extends BaseDao{
    /**
     * 根据排片ID查找所有的订票记录
     * @param scheduleid
     * @return 
     */
    public List<Order> getOrders(int scheduleid){
        String sql = "select * from orders where scheduleid=?";
        ResultSetHandler<List<Order>> h = new BeanListHandler<Order>(Order.class);
        List<Order> res = (List)query(sql, h, scheduleid);
        return res;
    }
    /**
     * 新建一条订票记录
     * @param order
     * @return 
     */
    public int addOrder(Order order){
        String sql = "insert into orders(scheduleid,accountid,seat, status)values(?,?,?,?)";
        int res = update(sql, order.getScheduleid(), order.getAccountid(), order.getSeat(), order.getStatus());
        return res;
    }
    /**
     * 更新订票记录状态
     * @param order
     * @return 
     */
    public int updateStatus(Order order){
        String sql = "update orders set status = ? where id=?";
        int res = update(sql, order.getStatus(), order.getId());
        return res;
    }
    /**
     * 获取用户的订票信息
     * @param accid
     * @return 
     */
    public List<Order> getAccountOrders(int accid){
        String sql = "select * from orders where accountid=?";
        ResultSetHandler<List<Order>> h = new BeanListHandler<Order>(Order.class);
        List<Order> res = (List)query(sql, h, accid);
        return res;
    }
}