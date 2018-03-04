package org.spring.framework.bean;

import java.util.Objects;

/**
 * 封装请求信息Bean
 *
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class Request {

    /**
     * 请求方法
     */
    private String requestMethod;

    /**
     * 请求路径
     */
    private String requestPath;

    public Request(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    //requestMethod和requestPath相同时认定对象相同
    @Override
    public int hashCode() {
        return Objects.hash(requestPath, requestMethod);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;

        return requestMethod.equals(request.getRequestMethod()) && requestPath.equals(request.getRequestPath());
    }

}
