package org.spring.framework.helper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.spring.framework.util.DbUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * 数据库操作帮助类
 *
 * @author jiangyixuan
 * @date 2018-03-14
 */
public class DBHelper {

    private static final BasicDataSource ds = new BasicDataSource();
    private static final QueryRunner runner = new QueryRunner(ds);

    //定义一个局部线程变量，使每个线程拥有自己的连接
    private static final ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

    static {
        System.out.println("init DbHelper...");

        //初始化dbcp数据源
        ds.setDriverClassName(ConfigHelper.getJdbcDriver());
        ds.setUrl(ConfigHelper.getJdbcUrl());
        ds.setUsername(ConfigHelper.getJdbcUserName());
        ds.setPassword(ConfigHelper.getJdbcPassWord());
        ds.setMaxActive(10);
        ds.setMaxIdle(5);
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static DataSource getDataSource() {
        return ds;
    }


    /**
     * 执行更新，包括update，insert，delete操作
     *
     * @param sql
     * @param params
     * @return
     */
    public static int update(String sql, Object... params) {
        //若当前线程存在连接，则传入，否则从数据源中获取连接 TODO ?
        Connection conn = connContainer.get();
        return DbUtil.update(runner, conn, sql, params);
    }

    public static ThreadLocal<Connection> getConnContainer() {
        return connContainer;
    }

    /**
     * 开启事务
     */
    public static void beginTransaction() {
        Connection conn = connContainer.get();
        if (conn == null) {
            try {
                conn = ds.getConnection();
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connContainer.set(conn);
            }
        }
    }

    /**
     * 提交事务
     */
    public static void commitTransaction() {
        Connection conn = connContainer.get();
        if (conn != null) {
            try {
                conn.commit();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connContainer.remove();
            }
        }
    }

    /**
     * 回滚事务
     */
    public static void rollbackTransaction() {
        Connection conn = connContainer.get();
        if (conn != null) {
            try {
                conn.rollback();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connContainer.remove();
            }
        }
    }

}
