package org.spring.framework.servlet;

import org.apache.log4j.BasicConfigurator;
import org.spring.framework.util.CodecUtil;
import org.spring.framework.util.StreamUtil;
import org.spring.framework.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
//容器在应用启动时就加载并初始化这个servlet
//@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        //使用slf4j默认配置
        BasicConfigurator.configure();
        System.out.println("===============HelloServlet init===================");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());
        System.out.println(req.getPathInfo());

        String s = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
        System.out.println(StringUtil.isEmpty(s) ? "null" : s);



    }
}
