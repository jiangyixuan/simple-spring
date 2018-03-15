package org.spring.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.framework.annottation.Aspect;
import org.spring.framework.helper.BeanHelper;
import org.spring.framework.helper.ClassHelper;
import org.spring.framework.util.CollectionUtil;
import org.spring.framework.util.StringUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jiangyixuan
 * @date 2018-03-12
 */
public class AOPHelper {

    private static final Logger logger = LoggerFactory.getLogger(AOPHelper.class);

    static {
        try {
            // 获取带有 @Aspect 注解的类（切面类）
            List<Class<?>> aspectClassList = ClassHelper.getClassListByAnnotation(Aspect.class);
            // 遍历所有切面类
            for (Class<?> aspectClass : aspectClassList) {
                // 获取 @Aspect 注解中的属性值
                Aspect aspect = aspectClass.getAnnotation(Aspect.class);
                String pkg = aspect.pkg();// 包名
                String cls = aspect.cls();// 类名
                // 初始化目标类列表
                List<Class<?>> targetClassList = new ArrayList<Class<?>>();
                if (StringUtil.isNotEmpty(pkg) && StringUtil.isNotEmpty(cls)) {
                    // 如果包名与类名均不为空，则添加指定类
                    targetClassList.add(Class.forName(pkg + "." + cls));
                } else {
                    // 否则（包名不为空）添加该包名下所有类
                    targetClassList.addAll(ClassHelper.getClassListByPackage(pkg));
                }
                // 遍历目标类列表
                if (CollectionUtil.isNotEmpty(targetClassList)) {
                    // 创建父切面类
                    BaseAspect baseAspect = (BaseAspect) aspectClass.newInstance();
                    for (Class<?> targetClass : targetClassList) {
                        // 获取目标实例
                        Object targetInstance = BeanHelper.getBean(targetClass);
                        // 创建代理实例
                        Object proxyInstance = baseAspect.getProxy(targetClass);
                        // 复制目标实例中的字段到代理实例中
                        Field[] declaredFields = targetClass.getDeclaredFields();
                        for (Field field : targetClass.getDeclaredFields()) {
                            field.setAccessible(true); // 可操作私有字段
                            field.set(proxyInstance, field.get(targetInstance));
                        }
                        // 用代理实例覆盖目标实例
                        BeanHelper.getBeanMap().put(targetClass, proxyInstance);
                    }
                }
            }

            Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
            logger.info("org.spring.framework.proxy.AOPHelper:" + "遍历容器中所有代理对象");
            for (Map.Entry entry : beanMap.entrySet()) {
                logger.info(entry.getKey() + "=" + entry.getValue());
            }
            logger.info("org.spring.framework.proxy.AOPHelper:" + "遍历结束");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
