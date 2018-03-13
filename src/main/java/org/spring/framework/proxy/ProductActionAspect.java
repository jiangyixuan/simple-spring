package org.spring.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.framework.annottation.Aspect;

import java.lang.reflect.Method;

/**
 * @author jiangyixuan
 * @date 2018-03-12
 */
@Aspect(pkg = "org.spring.framework.service.impl", cls = "")
public class ProductActionAspect extends BaseAspect {

    private static final Logger logger = LoggerFactory.getLogger(ProductActionAspect.class);
    private long begin;

    @Override
    protected boolean filter(Method method, Object[] args) {

        //过滤掉hashCode方法和toString方法
        return !("hashCode".equals(method.getName()) || "toString".equals(method.getName()));
    }

    @Override
    protected void before(Method method, Object[] args) {
        begin = System.currentTimeMillis();
    }

    @Override
    protected void after(Method method, Object[] args) {
        logger.info("org.spring.framework.proxy.ProductActionAspect:" + ":" + method.getName() + "方法执行时间为" + (System.currentTimeMillis() - begin) + "ms");
    }

    @Override
    protected void error(Method method, Object[] args, Exception e) {
        System.out.println("Errror:" + e.getMessage());
    }

}
