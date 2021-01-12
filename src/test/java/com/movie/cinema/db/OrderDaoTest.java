/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Account;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author zhch
 */
public class OrderDaoTest {
    AccountDao accDao;
    @BeforeEach
    void init(){
       DerbyUtil.test = true;
       accDao = new AccountDao();
       accDao.deleteAll();
       for(int i=0;i<5;i++){
           Account acc = new Account();
           acc.setId(i+1);
           acc.setUsername("a" + i);
           acc.setPassword("a" + i);
           acc.setBalance(100.0);
           accDao.insertAccount(acc);
       }
    }
    
    @Test
    void getAccountTest(){
        Account acc = accDao.getAccount("a1");
        assertTrue(acc != null);
    }
}
