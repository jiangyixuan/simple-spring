package org.spring.framework.helper;

import org.junit.Test;

import java.util.Set;

/**
 * @author jiangyixuan
 * @date 2018-03-02
 */
public class ClassHelperTest {

    @Test
    public void getControllerClassSet() {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        System.out.println(controllerClassSet);
    }

}
