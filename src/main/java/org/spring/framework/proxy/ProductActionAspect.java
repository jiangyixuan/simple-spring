package org.spring.framework.proxy;

/**
 * @author jiangyixuan
 * @date 2018-03-12
 */
public class ProductActionAspect extends BaseAspect {

    @Override
    protected Object advice(Pointcut pointcut, Object proxy, Object[] args) {

        long begin = System.currentTimeMillis();
        Object result = pointcut.invoke(proxy, args);
        System.out.println("Time: " + (System.currentTimeMillis() - begin) + "ms");

        return result;
    }

}
