package org.spring.framework.helper;

import org.junit.Test;
import org.spring.framework.util.ReflectionUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * Created by jiangyixuan on 2018/2/27.
 */
public class BeanHelperTest {

    @Test
    public void getBeanMap() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //TODO org.spring.framework.Param等含构造参数类不能被实例化，需要改变实例化方式

        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();

        for (Class cls : beanMap.keySet()) {
            System.out.println(cls.getName());
        }

    }

    @Test
    public void getBean() {
//        System.out.println(BeanHelper.getBean(Person.class));
    }

    @Test
    public void test() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("org.spring.framework.bean.View");
        Class<?> bClass = Class.forName("org.spring.framework.Person");

        Constructor<?>[] aConstructors = aClass.getConstructors();
        Constructor<?>[] bConstructors = bClass.getConstructors();

        for(Constructor constructor:aConstructors){
            Parameter[] parameters = constructor.getParameters();
            System.out.println("View:"+parameters.length);
        }

        for(Constructor constructor:bConstructors){
            Parameter[] parameters = constructor.getParameters();
            System.out.println("Person:"+parameters.length);

        }

        Object obj = ReflectionUtil.newInstance(aClass);
        System.out.println(obj);
    }

}
