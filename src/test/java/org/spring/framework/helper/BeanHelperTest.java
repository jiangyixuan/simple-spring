package org.spring.framework.helper;

import org.junit.Assert;
import org.junit.Test;
import org.spring.framework.service.impl.HelloServiceImpl;

import java.util.Map;

/**
 * Created by jiangyixuan on 2018/2/27.
 */
public class BeanHelperTest {

    @Test
    public void getBeanMap() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();

        for (Class cls : beanMap.keySet()) {
            System.out.println(cls.getName());
        }

    }

    @Test
    public void getAutowiredBean() {

        System.out.println(BeanHelper.getBean(HelloServiceImpl.class));
        Assert.assertNotNull(BeanHelper.getBean(HelloServiceImpl.class));
    }

}
