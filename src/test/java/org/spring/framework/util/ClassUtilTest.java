package org.spring.framework.util;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jiangyixuan
 * @date 2018-02-27
 */
public class ClassUtilTest {

    @Test
    public void loadClass() throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        Class<?> aClass = ClassUtil.loadClass("org.spring.framework.Person");
        System.out.println(aClass.newInstance());

        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    @Test
    public void addClass() {

        Set<Class<?>> set = new HashSet<Class<?>>();

        new ClassUtil().addClass(set, "G:\\Java高级架构师46阶段\\41.第四十一阶段、shiro综合教程\\另一套shiro\\shrio视频\\shiro第一天\\day01_shiro\\案例\\simple-spring\\target\\classes\\org\\spring\\framework",
                "org.spring.framework");
        for (Class aClass : set) {
            System.out.println(aClass.getName());
        }

    }

}
