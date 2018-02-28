package org.spring.framework;

/**
 * 提供相关配置项常量
 *
 * @author jiangyixuan
 * @date 2018-02-26
 */
public interface ConfigConstant {

    String UTF_8 = "UTF-8";

    String CONFIG_FILE = "simple-spring.properties";

    String JDBC_DRIVER = "spring.framework.jdbc.driver";
    String JDBC_URL = "spring.framework.jdbc.url";
    String JDBC_USERNAME = "spring.framework.jdbc.username";
    String JDBC_PASSWORD = "spring.framework.jdbc.password";

    String APP_BASE_PACKAGE = "spring.framework.app.base_package";
    String APP_JSP_PATH = "spring.framework.app.jsp_path";
    String APP_ASSERT_PATH = "spring.framework.app.asset_path";

}
