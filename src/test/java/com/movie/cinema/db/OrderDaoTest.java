/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Order;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Jiacheng Lv
 */
public class OrderDaoTest {
    OrderDao dao;
    @BeforeEach
    void init(){
       DerbyUtil.test = true;
       dao = new OrderDao();
       dao.deleteAll();
       for(int i=0;i<5;i++){
           Order acc = new Order();
           acc.setId(i+1);
           acc.setScheduleid(i+1);
           acc.setAccountid(1);
           acc.setSeat(i+1);
           acc.setStatus(0);
           dao.insertData(acc);
       }
    }
    
    @Test
    void getOrderTest(){
        List<Order> list = dao.getAccountOrders(1);
        assertTrue(list.size() == 5);
    }
}
