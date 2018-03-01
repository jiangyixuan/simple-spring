package org.spring.framework.other;


import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jiangyixuan
 * @date 2018-03-01
 */
public class Slf4jTest {

    private static final Logger logger = LoggerFactory.getLogger(Slf4jTest.class);

    static {
        BasicConfigurator.configure();
    }

    public static void main(String[] args) {
        System.out.println("123");
        logger.info("asd");

    }

}
