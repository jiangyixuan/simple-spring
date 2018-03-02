package org.spring.framework.helper;

import org.junit.Test;

/**
 * @author jiangyixuan
 * @date 2018-03-02
 */
public class ControllerHelperTest {

    @Test
    public void getHandler() {
        ControllerHelper.getHandler("get", "/hello");
    }

}
