package org.spring.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.framework.annottation.Aspect;
import org.spring.framework.annottation.Transaction;
import org.spring.framework.helper.DBHelper;

import java.lang.reflect.Method;

/**
 * @author jiangyixuan
 * @date 2018-03-15
 */
@Aspect(pkg = "org.spring.framework.service.impl", cls = "")
public class TransactionAspect extends BaseAspect {

    private static final Logger logger = LoggerFactory.getLogger(ProductActionAspect.class);

    @Override
    protected boolean filter(Method method, Object[] args) {

        //过滤掉hashCode方法和toString方法
        return method.isAnnotationPresent(Transaction.class);
    }

    @Override
    protected void before(Method method, Object[] args) {
        // 开启事务
        DBHelper.beginTransaction();
    }

    @Override
    protected void after(Method method, Object[] args) {
        // 提交事务
        DBHelper.commitTransaction();
    }

    @Override
    protected void error(Method method, Object[] args, Exception e) {
        // 回滚事务
        DBHelper.rollbackTransaction();
        logger.error("Errror:" + e.getMessage());
    }
}
