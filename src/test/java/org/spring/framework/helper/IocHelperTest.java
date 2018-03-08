package org.spring.framework.helper;

import org.junit.Assert;
import org.junit.Test;
import org.spring.framework.annottation.Autowired;
import org.spring.framework.util.ArrayUtil;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author jiangyixuan
 * @date 2018-03-08
 */
public class IocHelperTest {


    @Test
    public void autowiredTest() {

        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();

        for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
            //获取Bean类和Bean实例
            Class<?> beanClass = beanEntry.getKey();
            Object beanInstance = beanEntry.getValue();

            //获取Bean类定义的所有成员变量（不包括父类的成员变变量）
            Field[] beanFields = beanClass.getDeclaredFields();
            if (ArrayUtil.isNotEmpty(beanFields)) {
                for (Field beanField : beanFields) {
                    //判断当前Bean字段是否带有Autowired
                    if (beanField.isAnnotationPresent(Autowired.class)) {
                        //获取Bean字段对应的接口
                        Class<?> beanFieldClass = beanField.getType();
                        //获取该接口所有的实现类
                        List<Class<?>> classListByInterface = ClassHelper.getClassListByInterface(beanFieldClass);

                        Object beanFieldInstance = beanMap.get(classListByInterface.get(0));
                        if (beanFieldInstance != null) {
                            System.out.println(beanFieldInstance);
                        }
                        Assert.assertNotNull(beanFieldInstance);
                    }
                }
            }

        }
    }

}
