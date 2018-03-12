package org.spring.framework.helper;

import org.spring.framework.annottation.Controller;
import org.spring.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类操作助手类
 * TODO 待重构
 *
 * @author jiangyixuan
 * @date 2018-02-27
 */
public class ClassHelper {

    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下的所有类
     *
     * @return
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }


    /**
     * 获取应用包名下的所有Controller类
     *
     * @return
     */
    public static Set<Class<?>> getControllerClassSet() {

        Set<Class<?>> classSet = getClassSet();
        Set<Class<?>> result = new HashSet<Class<?>>();
        if (classSet != null) {
            for (Class<?> cls : classSet) {
                if (cls.isAnnotationPresent(Controller.class)) {
                    result.add(cls);
                }
            }
        }
        return result;
    }

    /**
     * 获取指定接口下的所有实现类
     *
     * @param interfaceClass
     * @return
     */
    public static List<Class<?>> getClassListByInterface(Class<?> interfaceClass) {
        Set<Class<?>> classSet = getClassSet();
        List<Class<?>> interfaceImpl = new ArrayList<Class<?>>();
        if (classSet != null) {
            for (Class<?> cls : classSet) {
                Class<?>[] interfaces = cls.getInterfaces();
                for (Class<?> interfaceCls : interfaces) {
                    if (interfaceClass.equals(interfaceCls)) {
                        interfaceImpl.add(cls);
                    }
                }
            }
        }
        return interfaceImpl;
    }

    /**
     * 获取基础包名下指定注解的类
     *
     * @param annotationClass
     * @return
     */
    public static List<Class<?>> getClassListByAnnotation(Class<? extends Annotation> annotationClass) {

        Set<Class<?>> classSet = getClassSet();
        List<Class<?>> annotationClasss = new ArrayList<Class<?>>();
        if (classSet != null) {
            for (Class<?> cls : classSet) {
                if (cls.isAnnotationPresent(annotationClass)) {
                    annotationClasss.add(cls);
                }
            }
        }
        return annotationClasss;
    }

    /**
     * 获取指定包名下的所有类
     */
    public static List<Class<?>> getClassListByPackage(String basePackage) {

        Set<Class<?>> classSet = ClassUtil.getClassSet(basePackage);
        List<Class<?>> annotationClasss = new ArrayList<Class<?>>();
        if (classSet != null) {
            for (Class<?> cls : classSet) {
                annotationClasss.add(cls);
            }
        }
        return annotationClasss;
    }

}