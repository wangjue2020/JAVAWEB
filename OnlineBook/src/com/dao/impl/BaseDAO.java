package com.dao.impl;

import com.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO {
    //use Dbutil to do actions for database
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * do Insert/Update/Delete queries
     * @return -1 means failed to update, otherwise the number of rows affected
     */
    public int update(String sql, Object...args){
        Connection conn = JDBCUtils.getConncection();

        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 查询返回一个javabean的sql语句
     * @param type  返回的对象类型
     * @param sql  执行的sql语句
     * @param args  sql对应的参数值
     * @param <T>   返回的类型的泛型
     * @return
     */
    public <T> T selectOne(Class<T> type, String sql, Object...args){
        Connection conn = JDBCUtils.getConncection();
        try {
            return queryRunner.query(conn, sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnect(conn);
        }
        return null;
    }

    /**
     * 查询返回多个javabean的sql语句
     * @param type  返回的对象类型
     * @param sql  执行的sql语句
     * @param args  sql对应的参数值
     * @param <T>   返回的类型的泛型
     * @return
     */
    public <T> List<T> selectForList(Class<T> type, String sql, Object... args){
        Connection conn = JDBCUtils.getConncection();
        try {
            return queryRunner.query(conn, sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnect(conn);
        }
        return null;
    }


    public Object selectForSingleValue(String sql, Object...args){
        Connection conn = JDBCUtils.getConncection();
        try {
            queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.closeConnect(conn);
        }
        return null;
    }
}
