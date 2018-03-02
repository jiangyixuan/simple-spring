package org.spring.framework.helper;

import org.junit.Test;
import org.spring.framework.bean.Handler;

/**
 * @author jiangyixuan
 * @date 2018-03-02
 */
public class ControllerHelperTest {

    @Test
    public void getHandler() {
        Handler get = ControllerHelper.getHandler("get", "/hello");
        System.out.println(get);
    }

}
