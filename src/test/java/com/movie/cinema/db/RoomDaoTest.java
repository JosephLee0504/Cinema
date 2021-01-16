/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Room;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Jiacheng Lv
 */
public class RoomDaoTest {
    RoomDao dao;
    @BeforeEach
    void init(){
       DerbyUtil.test = true;
       dao = new RoomDao();
       dao.deleteAll();
       for(int i=0;i<5;i++){
           Room obj = new Room();
           obj.setId(i+1);
           obj.setName("room" + i);
           obj.setCinemaid(1);
           obj.setSeatcount(100);
           dao.insertData(obj);
       }
    }
    
    @Test
    void getRoomTest(){
        List<Room> list = dao.getRooms();
        assertTrue(list.size() == 5);
    }
}
