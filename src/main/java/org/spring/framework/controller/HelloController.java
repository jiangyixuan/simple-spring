package org.spring.framework.controller;

import org.spring.framework.Person;
import org.spring.framework.annottation.Action;
import org.spring.framework.annottation.Autowired;
import org.spring.framework.annottation.Controller;
import org.spring.framework.bean.Data;
import org.spring.framework.bean.Param;
import org.spring.framework.service.HelloService;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Action("get:/hello")
    public Data hello(Param param) {

        Person person = helloService.getPerson();
        Data data = new Data(person);

        return data;
    }

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
