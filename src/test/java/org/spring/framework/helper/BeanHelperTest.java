package org.spring.framework.helper;

import org.junit.Test;
import org.spring.framework.service.impl.UserServiceImpl;

import java.util.Map;

/**
 * Created by jiangyixuan on 2018/2/27.
 */
public class BeanHelperTest {

    @Test
    public void getBeanMap() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();

    }

    @Test
    public void getAutowiredBean() {

        System.out.println(BeanHelper.getBean(UserServiceImpl.class));
    }

}
