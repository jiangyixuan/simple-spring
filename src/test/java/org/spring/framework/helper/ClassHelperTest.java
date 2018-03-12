package org.spring.framework.helper;

import org.junit.Assert;
import org.junit.Test;
import org.spring.framework.annottation.Controller;

import java.util.List;
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


    @Test
    public void getClassListByAnnotation() {
        List<Class<?>> classListByAnnotation = ClassHelper.getClassListByAnnotation(Controller.class);
        Assert.assertNotNull(classListByAnnotation);
    }


}
