/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Account;
import com.movie.cinema.model.Cinema;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author zhch
 */
public class CinemaDaoTest {
    CinemaDao dao;
    @BeforeEach
    void init(){
       DerbyUtil.test = true;
       dao = new CinemaDao();
       dao.deleteAll();
       for(int i=0;i<5;i++){
           Cinema obj = new Cinema();
           obj.setId(i+1);
           obj.setName("cinema" + i);
           obj.setAddress("street" + i);
           dao.insertData(obj);
       }
    }
    
    @Test
    void getCinemasTest(){
        List<Cinema> list = dao.getCinemas();
        assertEquals(5, list.size());
    }
}
