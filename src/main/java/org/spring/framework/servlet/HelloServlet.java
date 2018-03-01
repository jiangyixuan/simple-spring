package org.spring.framework.servlet;

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
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("===============HelloServletinit===================");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());
        System.out.println(req.getPathInfo());


    }
}
