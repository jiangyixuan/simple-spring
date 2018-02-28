package org.spring.framework;

import org.spring.framework.helper.BeanHelper;
import org.spring.framework.helper.ClassHelper;
import org.spring.framework.helper.ControllerHelper;
import org.spring.framework.helper.IocHelper;
import org.spring.framework.util.ClassUtil;

/**
 * 加载IOC使用到的Helper类
 *
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }

}
