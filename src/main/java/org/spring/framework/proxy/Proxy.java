package org.spring.framework.proxy;

/**
 * 代理接口
 *
 * @author jiangyixuan
 * @date 2018-03-09
 */
public interface Proxy {

    /**
     * 执行链式代理
     *
     * @param proxyChain
     * @return
     */
    Object doProxy(ProxyChain proxyChain);

}
