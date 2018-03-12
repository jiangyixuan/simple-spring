package org.spring.framework.annottation;

import java.lang.annotation.*;

/**
 * 切面注解
 *
 * @author jiangyixuan
 * @date 2018-03-07
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * 注解
     *
     * @return
     */
    Class<? extends Annotation> value() default Aspect.class;

    /**
     * 包名
     *
     * @return
     */
    String pkg() default "";

    /**
     * 类名
     *
     * @return
     */
    String cls() default "";

}
