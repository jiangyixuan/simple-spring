package org.spring.framework.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;

/**
 * @author jiangyixuan
 * @date 2018-02-26
 */
public class CollectionUtil {

    /**
     * 判断集合是否非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return CollectionUtils.isNotEmpty(collection);
    }

    /**
     * 判断集合是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtils.isEmpty(collection);
    }

}
