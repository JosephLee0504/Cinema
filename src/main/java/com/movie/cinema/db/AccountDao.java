/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import com.movie.cinema.model.Account;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author Tianyang Li
 */
public class AccountDao extends BaseDao{
    /**
     * Add a user account
     * @param username
     * @param password
     * @param balance
     * @return 
     */
    public int addAccount(String username, String password, double balance){
        String sql = "insert into accounts(username,password,balance)values(?,?,?)";
        int res = update(sql, username, password, balance);
        return res;
    }
    /**
     * Find users by username and password
     * @param username
     * @param password
     * @return 
     */
    public Account getAccount(String username, String password){
        String sql = "select * from accounts where username=? and password=?";
        ResultSetHandler<Account> h = new BeanHandler<>(Account.class);
        Account res = (Account)query(sql, h, username, password);
        return res;
    }
    /**
     * Find the user by user name
     * @param username
     * @return 
     */
    public Account getAccount(String username){
        String sql = "select * from accounts where username=?";
        ResultSetHandler<Account> h = new BeanHandler<>(Account.class);
        Account res = (Account)query(sql, h, username);
        return res;
    }
    
    /**
     * Query all user information by ID
     * @param ids
     * @return 
     */
    public Map<Integer, Account> getAccountsMap(List<Integer> ids){
        List<Account> list = getAccounts(ids);
        Map<Integer, Account> map = new HashMap<>();
        list.forEach(c -> {
            map.put(c.getId(), c);
        });
        return map;
    }
    /**
     * Query all user information by ID
     * @param ids
     * @return 
     */
    public List<Account> getAccounts(List<Integer> ids){
        if(ids==null || ids.isEmpty()){
            return new ArrayList<>();
        }
        String sql = "select * from accounts where id in " + listToString(ids);
        ResultSetHandler<List<Account>> h;
        h = new BeanListHandler<>(Account.class);
        List<Account> res = (List)query(sql, h);
        return res;
    }
    /**
     * Update account information
     * @param acc
     * @return 
     */
    public int updateAccount(Account acc){
        String sql = "update accounts set username=?, password=?, balance=? where id=?";
        int res = update(sql, acc.getUsername(), acc.getPassword(), acc.getBalance(), acc.getId());
        return res;
    }
    /**
     * Delete all data
     * @return 
     */
    public int deleteAll(){
        String sql = "delete from accounts where id > -1";
        int res = update(sql);
        return res;
    }
    /** 
     * Insert a piece of data
     * @param acc
     * @return 
     */
    public int insertAccount(Account acc){
        String sql = "insert into accounts (id, username, password, balance) values(?,?,?,?)";
        int res = update(sql, acc.getId(), acc.getUsername(), acc.getPassword(), acc.getBalance());
        return res;
    }
}
