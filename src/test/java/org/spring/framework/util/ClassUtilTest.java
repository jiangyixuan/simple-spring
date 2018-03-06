package org.spring.framework.util;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Enumeration;
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

        new ClassUtil().addClass(set, "E:\\simple-spring\\target\\classes\\org\\spring\\framework",
                "org.spring.framework");
        for (Class aClass : set) {
            System.out.println(aClass.getName());
        }
    }

    @Test
    public void getClassSet() throws IOException {

        Set<Class<?>> classSet = ClassUtil.getClassSet("org.spring.framework");
        for (Class aClass : classSet) {
            System.out.println(aClass.getName());
        }

        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("org/spring/framework");

        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            if (url != null) {
                String protocol = url.getProtocol();
                System.out.println(protocol);
                System.out.println(url.getFile());

            }
        }
    }

}
