package org.spring.framework.helper;

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


}
