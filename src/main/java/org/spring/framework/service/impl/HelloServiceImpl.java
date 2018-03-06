package org.spring.framework.service.impl;

import org.spring.framework.Person;
import org.spring.framework.service.HelloService;

/**
 * @author jiangyixuan
 * @date 2018-03-06
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public Person getPerson() {

        Person person = new Person();
        person.setName("jiangyixuan");
        person.setAge(24);

        return person;
    }
}
