package org.spring.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.framework.annottation.Aspect;

/**
 * @author jiangyixuan
 * @date 2018-03-12
 */
@Aspect(pkg = "org.spring.framework.service.impl", cls = "")
public class ProductActionAspect extends BaseAspect {

    private static final Logger logger = LoggerFactory.getLogger(ProductActionAspect.class);

    @Override
    protected Object advice(Pointcut pointcut, Object proxy, Object[] args) {

        long begin = System.currentTimeMillis();
        Object result = pointcut.invoke(proxy, args);
        logger.info("org.spring.framework.proxy.ProductActionAspect:" + proxy.getClass() + ":" + pointcut.getMethodTarget().getName() + "方法执行时间为" + (System.currentTimeMillis() - begin) + "ms");

        return result;
    }

}
