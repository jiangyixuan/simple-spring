package org.spring.framework.controller;

import org.spring.framework.annottation.Action;
import org.spring.framework.annottation.Controller;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
@Controller
public class HelloController {

    @Action("/hello")
    public void hello() {

    }

}
