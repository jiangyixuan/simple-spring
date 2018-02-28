package org.spring.framework.other;

import org.spring.framework.bean.Request;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class RequestTest {

    public static void main(String[] args) {
        Request request1 = new Request("GET", "/hello");
        System.out.println(request1.hashCode());

        Request request2 = new Request("GET", "/hello");
        System.out.println(request2.hashCode());
    }

}
