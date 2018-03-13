package org.spring.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jiangyixuan
 * @date 2018-03-12
 */
public abstract class BaseAspect implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object proxy, Method methodTarget, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        if (filter(methodTarget, args)) {
            before(methodTarget, args);
            try {
                result = methodProxy.invokeSuper(proxy, args);
            } catch (Exception e) {
                e.printStackTrace();
                error(methodTarget, args, e);
            }
            after(methodTarget, args);
        } else {
            result = methodProxy.invokeSuper(proxy, args);
        }
        return result;

    }

    protected boolean filter(Method method, Object[] args) {
        return true;
    }

    protected void before(Method method, Object[] args) {
    }

    protected void after(Method method, Object[] args) {
    }

    protected void error(Method method, Object[] args, Exception e) {
    }

}
