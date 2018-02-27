package org.spring.framework.helper;

import org.spring.framework.ConfigConstant;
import org.spring.framework.util.PropsUtil;

import java.util.Properties;

/**
 * @author jiangyixuan
 * @date 2018-02-26
 */
public class ConfigHelper {

    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取Jdbc驱动
     *
     * @return
     */
    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取Jdbc URL
     *
     * @return
     */
    public static String getJdbcUrl() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     * 获取Jdbc 用户名
     *
     * @return
     */
    public static String getJdbcUserName() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取Jdbc 密码
     *
     * @return
     */
    public static String getJdbcPassWord() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

}
