package org.spring.framework.util;

import org.apache.commons.dbutils.QueryRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author jiangyixuan
 * @date 2018-03-15
 */
public class DbUtil {

    private static final Logger logger = LoggerFactory.getLogger(DbUtil.class);

    /**
     * 更新（包括 UPDATE、INSERT、DELETE，返回受影响的行数）
     *
     * @param queryRunner
     * @param conn
     * @param sql
     * @param params
     * @return
     */
    public static int update(QueryRunner queryRunner, Connection conn, String sql, Object... params) {
        int result;
        try {
            if (conn != null) {
                result = queryRunner.update(conn, sql, params);
            } else {
                result = queryRunner.update(sql, params);
            }

        } catch (SQLException e) {
            logger.error("更新出错！", e);
            throw new RuntimeException(e);
        }
        printSQL(sql);
        return result;
    }

    private static void printSQL(String sql) {
        logger.debug("[simple-spring] SQL - {}", sql);
    }

}
