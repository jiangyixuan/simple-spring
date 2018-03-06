package org.spring.framework.other;

import org.junit.Test;
import org.spring.framework.controller.HelloController;
import org.spring.framework.service.HelloService;
import org.spring.framework.service.impl.HelloServiceImpl;

import java.lang.reflect.Field;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Class cls = Class.forName("org.spring.framework.service.impl.HelloServiceImpl");
        Class cls2 = Class.forName("org.spring.framework.service.HelloService");
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
            Class<?> aClass = Class.forName("org.spring.framework.Person");

            Field[] fields = aClass.getDeclaredFields();

            for (Field field : fields) {
                System.out.println(field.getType());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void setField() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {

        Class<?> cClass = Class.forName("org.spring.framework.controller.HelloController");
        HelloController helloController = (HelloController) cClass.newInstance();
        HelloService helloService = helloController.getHelloService();
        for (Field field : cClass.getDeclaredFields()) {

            field.setAccessible(true);
            field.set(helloController, new HelloServiceImpl());

        }
        HelloService helloService1 = helloController.getHelloService();
    }


}
