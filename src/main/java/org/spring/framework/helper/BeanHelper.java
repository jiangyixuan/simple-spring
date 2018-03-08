package org.spring.framework.helper;

import org.spring.framework.util.ReflectionUtil;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author jiangyixuan
 * @date 2018/2/27
 */
public class BeanHelper {

    /**
     * 定义bean映射，用于存放Bean类与Bean实例的映射关系
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getClassSet();

        for (Class<?> beanClass : beanClassSet) {
            //过滤掉接口以及注解
            if (!beanClass.isInterface() && !beanClass.isAnnotation()) {

                //记录是否有重载的构造方法
                boolean temp = false;
                Constructor<?>[] aConstructors = beanClass.getConstructors();
                for(Constructor constructor:aConstructors){
                    if(constructor.getParameterAnnotations().length>0){
                        temp = true;
                    }
                }
                if(!temp){
                    Object obj = ReflectionUtil.newInstance(beanClass);
                    BEAN_MAP.put(beanClass, obj);
                }
            }

        }
    }

    /**
     * 获取Bean映射
     *
     * @return
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> cls){

        if(!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean by class："+cls);
        }
        return (T)BEAN_MAP.get(cls);
    }

}
