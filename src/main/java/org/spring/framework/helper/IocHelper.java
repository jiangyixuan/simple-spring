package org.spring.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.framework.annottation.Autowired;
import org.spring.framework.util.ArrayUtil;
import org.spring.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * 初始化IOC容器
 *
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class IocHelper {

    private static final Logger logger = LoggerFactory.getLogger(IocHelper.class);

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
                        //获取该接口所有的实现类
                        List<Class<?>> classListByInterface = ClassHelper.getClassListByInterface(beanFieldClass);

                        Object beanFieldInstance = beanMap.get(classListByInterface.get(0));

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
