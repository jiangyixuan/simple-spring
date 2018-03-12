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
        return advice(new Pointcut(methodTarget, methodProxy), proxy, args);
    }

    protected abstract Object advice(Pointcut pointcut, Object proxy, Object[] args);

    protected class Pointcut {

        private Method methodTarget;
        private MethodProxy methodProxy;

        public Pointcut(Method methodTarget, MethodProxy methodProxy) {
            this.methodTarget = methodTarget;
            this.methodProxy = methodProxy;
        }

        public Method getMethodTarget() {
            return methodTarget;
        }

        public MethodProxy getMethodProxy() {
            return methodProxy;
        }

        public Object invoke(Object proxy, Object[] args) {
            Object result = null;
            try {
                result = methodProxy.invokeSuper(proxy, args);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
