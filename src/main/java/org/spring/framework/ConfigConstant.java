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

    String PAGE_NOT_FIND = "<!DOCTYPE html>\n" +
            "<html lang=en>\n" +
            "<meta charset=utf-8>\n" +
            "<meta name=viewport content=\"initial-scale=1, minimum-scale=1, width=device-width\">\n" +
            "<title>Error 404 (Not Found)!!1</title>\n" +
            "<style>\n" +
            "    * {\n" +
            "        margin: 0;\n" +
            "        padding: 0\n" +
            "    }\n" +
            "\n" +
            "    html, code {\n" +
            "        font: 15px/22px arial, sans-serif\n" +
            "    }\n" +
            "\n" +
            "    html {\n" +
            "        background: #fff;\n" +
            "        color: #222;\n" +
            "        padding: 15px\n" +
            "    }\n" +
            "\n" +
            "    body {\n" +
            "        margin: 7% auto 0;\n" +
            "        max-width: 390px;\n" +
            "        min-height: 180px;\n" +
            "        padding: 30px 0 15px\n" +
            "    }\n" +
            "\n" +
            "    * > body {\n" +
            "        background: url() 100% 5px no-repeat;\n" +
            "        padding-right: 205px\n" +
            "    }\n" +
            "\n" +
            "    p {\n" +
            "        margin: 11px 0 22px;\n" +
            "        overflow: hidden\n" +
            "    }\n" +
            "\n" +
            "    ins {\n" +
            "        color: #777;\n" +
            "        text-decoration: none\n" +
            "    }\n" +
            "\n" +
            "    a img {\n" +
            "        border: 0\n" +
            "    }\n" +
            "\n" +
            "    @media screen and (max-width: 772px) {\n" +
            "        body {\n" +
            "            background: none;\n" +
            "            margin-top: 0;\n" +
            "            max-width: none;\n" +
            "            padding-right: 0\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    #logo {\n" +
            "        background: url(//www.google.com/images/branding/googlelogo/1x/googlelogo_color_150x54dp.png) no-repeat;\n" +
            "        margin-left: -5px\n" +
            "    }\n" +
            "\n" +
            "    @media only screen and (min-resolution: 192dpi) {\n" +
            "        #logo {\n" +
            "            background: url(//www.google.com/images/branding/googlelogo/2x/googlelogo_color_150x54dp.png) no-repeat 0% 0%/100% 100%;\n" +
            "            -moz-border-image: url(//www.google.com/images/branding/googlelogo/2x/googlelogo_color_150x54dp.png) 0\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    @media only screen and (-webkit-min-device-pixel-ratio: 2) {\n" +
            "        #logo {\n" +
            "            background: url() no-repeat;\n" +
            "            -webkit-background-size: 100% 100%\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    #logo {\n" +
            "        display: inline-block;\n" +
            "        height: 54px;\n" +
            "        width: 150px\n" +
            "    }\n" +
            "</style>\n" +
            "<p><b>404.</b>\n" +
            "    <ins>That’s an error.</ins>\n" +
            "<p>The requested URL was not found on this server.\n" +
            "    <ins>That’s all we know.</ins>\n";

}
