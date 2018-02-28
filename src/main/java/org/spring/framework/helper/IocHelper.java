package org.spring.framework.helper;

import org.spring.framework.annottation.Autowired;
import org.spring.framework.util.ArrayUtil;
import org.spring.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 初始化IOC容器
 *
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class IocHelper {

    static {
        //获取并遍历所有的Bean类
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
                        Object beanFieldInstance = beanMap.get(beanFieldClass);

                        if (beanFieldInstance != null) {
                            //通过反射初始化BeanField的值
                            ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                        }

                    }
                }
            }

        }
    }

}
