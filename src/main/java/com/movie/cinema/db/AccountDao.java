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
     * 添加一个用户帐号
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
     * 根据用户名密码查找用户
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
     * 根据用户名查找用户
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
     * 根据id 查询所有的用户信息
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
     * 根据id 查询所有的用户信息
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
     * 更新账号信息
     * @param acc
     * @return 
     */
    public int updateAccount(Account acc){
        String sql = "update accounts set username=?, password=?, balance=? where id=?";
        int res = update(sql, acc.getUsername(), acc.getPassword(), acc.getBalance(), acc.getId());
        return res;
    }
    /**
     * 删除所有数据
     * @return 
     */
    public int deleteAll(){
        String sql = "delete from accounts where id > -1";
        int res = update(sql);
        return res;
    }
    /** 
     * 插入一条数据
     * @param acc
     * @return 
     */
    public int insertAccount(Account acc){
        String sql = "insert into accounts (id, username, password, balance) values(?,?,?,?)";
        int res = update(sql, acc.getId(), acc.getUsername(), acc.getPassword(), acc.getBalance());
        return res;
    }
}
