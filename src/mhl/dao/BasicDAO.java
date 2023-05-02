package mhl.dao;
import mhl.utils.JDBCutilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> {
    //增删改查
    QueryRunner qr=new QueryRunner();
    public int update(String sql,Object... parameters){
        Connection connection = null;
        try {
            connection= JDBCutilsByDruid.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //返回多个查询对象针对任意表
    public List<T> queryMuLti(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;
        try {
            connection=JDBCutilsByDruid.getConnection();
            List<T> query = qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
            return  query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //返回单个查询对象针对任意表
    public T querySingle(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;
        try {
            connection=JDBCutilsByDruid.getConnection();
            T query = qr.query(connection, sql, new BeanHandler<>(clazz), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //返回单行单列，返回单值的方法
    public Object queryScalar(String sql,Object... parameters){
        Connection connection = null;
        try {
            connection=JDBCutilsByDruid.getConnection();
            Object query = qr.query(connection, sql, new ScalarHandler<>(), parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
