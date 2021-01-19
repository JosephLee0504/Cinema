/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.cinema.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * Base classes for database operations
 * @author Tianyang Li
 * @param <T>
 */
public  class BaseDao<T> {
    public QueryRunner runner = new QueryRunner();
    
    /**
     * Wrap the queryRunner.query () method, leaving error cases to be handled
     * @param <T>
     * @param sql
     * @param rsh
     * @return 
     */
    public <T extends Object> T query(String sql, ResultSetHandler<T> rsh){
        Connection conn = DerbyUtil.getConn();
        try{
            T res = runner.query(conn, sql, rsh);
            return res;
        }catch(SQLException e){
        }finally{
            DerbyUtil.close(conn);
        }
        return null;
    }
    
    /**
     * Wrap the queryRunner.query () method, leaving error cases to be handled
     * @param <T>
     * @param sql
     * @param rsh
     * @param params
     * @return 
     */
    public <T extends Object> T query(String sql, ResultSetHandler<T> rsh, Object...params){
        Connection conn = DerbyUtil.getConn();
        try{
            T res = runner.query(conn, sql, rsh, params);
            return res;
        }catch(SQLException e){
        }finally{
            DerbyUtil.close(conn);
        }
        return null;
    }
    /**
     * Wrap the queryRunner.update () method, leaving error cases to be handled
     * @param sql
     * @return 
     */
    public int update(String sql){
        Connection conn = DerbyUtil.getConn();
        try{
            int res = runner.update(conn, sql);
            return res;
        }catch(SQLException e){
        }finally{
            DerbyUtil.close(conn);
        }
        return 0;
    }
    
    /**
     * Wrap the queryRunner.update () method, leaving error cases to be handled
     * @param sql
     * @param params
     * @return 
     */
    public int update(String sql, Object...params){
        Connection conn = DerbyUtil.getConn();
        try{
            int res = runner.update(conn, sql, params);
            return res;
        }catch(SQLException e){
        }finally{
            DerbyUtil.close(conn);
        }
        return 0;
    }
    
    /**
     * Replace the list with a string
     * @param list
     * @return 
     */
    public String listToString(List list){
        String res = "(";
        int i = 0;
        for(Object o : list){
            if(i>0){
                res += ",";
            }
            res += o.toString();
            i++;
        }
        res += ")";
        return res;
    }
}
