package org.spring.framework;

import org.apache.log4j.BasicConfigurator;
import org.spring.framework.bean.Handler;
import org.spring.framework.bean.Param;
import org.spring.framework.helper.BeanHelper;
import org.spring.framework.helper.ConfigHelper;
import org.spring.framework.helper.ControllerHelper;
import org.spring.framework.util.ArrayUtil;
import org.spring.framework.util.CodecUtil;
import org.spring.framework.util.StreamUtil;
import org.spring.framework.util.StringUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求转发器
 *
 * @author jiangyixuan
 * @date 2018-02-28
 */

public class DispatcherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        //暂时先使用slf4j默认配置
        BasicConfigurator.configure();
        //初始化相关Helper类
        HelperLoader.init();
        //获取ServletContext对象（用于注册Servlet）
        ServletContext servletContext = getServletConfig().getServletContext();
        //注册处理JSP的Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        //注册处理静态资源额默认Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方法与请求路径
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();

        //获取Action处理器
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (handler != null) {
            //获取Controller类及其Bean实例

            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            //创建请求参数对象
            Map<String, Object> paramMap = new HashMap<String, Object>();

            //获取url参数
            Enumeration<String> parameterNames = req.getParameterNames();

            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = req.getParameter(paramName);

                paramMap.put(paramName, paramValue);
            }

            //获取请求体参数
            String body = CodecUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
            if (StringUtil.isNotEmpty(body)) {
                //当前仅当  Content-Type: application/x-www-form-urlencoded
                String[] params = StringUtil.splitString(body, "&");
                if (ArrayUtil.isNotEmpty(params)) {
                    for (String param : params) {
                        String[] array = StringUtil.splitString(param, "=");
                        if (ArrayUtil.isNotEmpty(array)) {
                            String paramName = array[0];
                            String paramValue = array[1];

                            paramMap.put(paramName, paramValue);
                        }
                    }
                }
            }
            Param param = new Param(paramMap);



        }


    }
}
