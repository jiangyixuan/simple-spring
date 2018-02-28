package org.spring.framework.helper;

import org.junit.Test;
import org.spring.framework.Person;

/**
 * Created by jiangyixuan on 2018/2/27.
 */
public class BeanHelperTest {

    @Test
    public void getBeanMap() {
        System.out.println(BeanHelper.getBeanMap());
    }

    @Test
    public void getBean() {
        System.out.println(BeanHelper.getBean(Person.class));
    }

}
