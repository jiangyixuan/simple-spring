package org.spring.framework;

/**
 * @author jiangyixuan
 * @date 2018-02-27
 */
public class Person {

    static {
        System.out.println("运行Person类静态代码块");
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
