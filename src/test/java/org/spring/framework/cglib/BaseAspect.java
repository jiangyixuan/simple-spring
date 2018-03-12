package org.spring.framework.cglib;

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
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        return advice(new Pointcut(method, methodProxy), o, objects);
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

        public void setMethodTarget(Method methodTarget) {
            this.methodTarget = methodTarget;
        }

        public MethodProxy getMethodProxy() {
            return methodProxy;
        }

        public void setMethodProxy(MethodProxy methodProxy) {
            this.methodProxy = methodProxy;
        }
    }

}
