package org.spring.framework.helper;

import org.junit.Test;

import java.util.Map;

/**
 * Created by jiangyixuan on 2018/2/27.
 */
public class BeanHelperTest {

    @Test
    public void getBeanMap() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();

        for (Map.Entry entry : beanMap.entrySet()) {
            System.out.println(entry.getKey());
        }

    }


}
