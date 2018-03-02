package org.spring.framework.helper;

import org.spring.framework.annottation.Action;
import org.spring.framework.bean.Handler;
import org.spring.framework.bean.Request;
import org.spring.framework.util.ArrayUtil;
import org.spring.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class ControllerHelper {

    /**
     * 用于存放请求与处理器的映射关系
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {

            //遍历这些Controller类
            for (Class<?> controllerClass : controllerClassSet) {

                //获取Controller类中定义的方法并且遍历
                Method[] methods = controllerClass.getDeclaredMethods();
                for (Method method : methods) {

                    //判断当前方法是否带有Action注解
                    if (method.isAnnotationPresent(Action.class)) {
                        //从Action注解中获取URL的映射规则
                        Action action = method.getAnnotation(Action.class);
                        String mapping = action.value();

                        //验证URL映射规则,url为 ACTION_MAP:/hello 形式
                        if (true) {
                            String[] array = mapping.split(":");
                            if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                                //获取请求方法和请求路径
                                String requestMethod = array[0];
                                String requestPath = array[1];

                                Request request = new Request(requestMethod, requestPath);
                                Handler handler = new Handler(controllerClass, method);
                                //初始化Action Map
                                ACTION_MAP.put(request, handler);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取Handler映射器
     *
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod, String requestPath) {

        Request request = new Request(requestMethod, requestPath);

        return ACTION_MAP.get(request);
    }

}
