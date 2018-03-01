package org.spring.framework.controller;

import org.spring.framework.Person;
import org.spring.framework.annottation.Action;
import org.spring.framework.annottation.Controller;
import org.spring.framework.bean.Data;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
@Controller
public class HelloController {

    @Action("/hello")
    public Data hello() {

        Person person = new Person();
        person.setName("jiangyixuan");
        person.setAge(24);
        Data data = new Data(person);

        return data;
    }

}
