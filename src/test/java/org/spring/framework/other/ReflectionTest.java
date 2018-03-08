package org.spring.framework.other;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Class cls = Class.forName("org.spring.framework.service.impl.UserServiceImpl");
        Class cls2 = Class.forName("org.spring.framework.service.UserService");
        Class[] interfaces = cls.getInterfaces();

        for (Class cla : interfaces) {
            System.out.println(cla);
            System.out.println(cls2);

            System.out.println(cla.equals(cls2));

        }
    }

    @Test
    public void fieldMethodTest() {

        try {
            Class<?> aClass = Class.forName("org.spring.framework.User");

            Field[] fields = aClass.getDeclaredFields();

            for (Field field : fields) {
                System.out.println(field.getType());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
