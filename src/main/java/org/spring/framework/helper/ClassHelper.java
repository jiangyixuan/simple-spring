package org.spring.framework.helper;

import org.spring.framework.annottation.Controller;
import org.spring.framework.util.ClassUtil;

import java.util.Set;

/**
 * 类操作助手类
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
        if (classSet != null) {
            for (Class<?> cls : classSet) {
                if (cls.isAnnotationPresent(Controller.class)) {
                    classSet.remove(cls);
                }
            }
        }
        return classSet;
    }

}
