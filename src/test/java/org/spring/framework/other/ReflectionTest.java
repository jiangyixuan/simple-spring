package org.spring.framework.other;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class ReflectionTest {

    @Test
    public void fieldMethodTest() {

        try {
            Class<?> aClass = Class.forName("org.spring.framework.Person");

            Field[] fields = aClass.getDeclaredFields();

            for (Field field : fields) {
                System.out.println(field.getType());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
