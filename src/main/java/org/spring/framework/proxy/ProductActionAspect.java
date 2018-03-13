package org.spring.framework.proxy;

import org.spring.framework.annottation.Aspect;

/**
 * @author jiangyixuan
 * @date 2018-03-12
 */
@Aspect(pkg = "org.spring.framework.controller", cls = "")
public class ProductActionAspect extends BaseAspect {

    @Override
    protected Object advice(Pointcut pointcut, Object proxy, Object[] args) {

        long begin = System.currentTimeMillis();
        Object result = pointcut.invoke(proxy, args);
        System.out.println(proxy + "=" + pointcut.getMethodTarget().getName() + "方法执行时间为" + (System.currentTimeMillis() - begin) + "ms");

        return result;
    }

}
