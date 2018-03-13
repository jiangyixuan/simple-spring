package org.spring.framework.controller;

import org.spring.framework.annottation.Action;
import org.spring.framework.annottation.Autowired;
import org.spring.framework.annottation.Controller;
import org.spring.framework.bean.Param;
import org.spring.framework.service.PersonService;

/**
 * @author jiangyixuan
 * @date 2018-03-13
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @Action("get:/hello")
    public void hello(Param param) {
        personService.hello();
    }

}
