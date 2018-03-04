package org.spring.framework.controller;

import org.spring.framework.Person;
import org.spring.framework.annottation.Action;
import org.spring.framework.annottation.Controller;
import org.spring.framework.bean.Data;
import org.spring.framework.bean.Param;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
@Controller
public class HelloController {

    @Action("get:/hello")
    public Data hello(Param param) {

        Person person = new Person();
        person.setName("jiangyixuan");
        person.setAge(24);
        Data data = new Data(person);

        return data;
    }

}
