package org.spring.framework.servlet;

import org.apache.log4j.BasicConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
//容器在应用启动时就加载并初始化这个servlet
//@WebServlet(urlPatterns = "/hello", loadOnStartup = 0)
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        //使用slf4j默认配置
        BasicConfigurator.configure();
        System.out.println("===============HelloServlet init===================");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.getRequestDispatcher("/asset/html/hello.html").forward(req, resp);

//        resp.sendRedirect("asset/html/hello.html");

        req.setAttribute("name", "jiangyixuan");
        req.setAttribute("age", 24);
        req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);

    }
}
