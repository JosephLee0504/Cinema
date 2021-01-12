/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Account;
import com.movie.cinema.model.Movie;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author zhch
 */
public class MovieDaoTest {
    MovieDao dao;
    @BeforeEach
    void init(){
        String[] types = new String[]{"fight", "love", "story"};
       DerbyUtil.test = true;
       dao = new MovieDao();
       dao.deleteAll();
       for(int i=0;i<5;i++){
           Movie obj = new Movie();
           obj.setId(i+1);
           obj.setName("movie" + i);
           obj.setMtype("fight" + types[i%types.length]);
           obj.setMtime(120);
           obj.setMdesc("This is a good film. " + i);
           obj.setImage("movie01.jpg");
           obj.setPublishtime("2020-12-12");
           dao.insertData(obj);
       }
    }
    
    @Test
    void getAccountTest(){
        List<Movie> list = dao.getMovies();
        assertTrue(list.size() == 5);
    }
}
