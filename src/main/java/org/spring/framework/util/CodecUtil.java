package org.spring.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.framework.ConfigConstant;

import java.net.URLDecoder;

/**
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class CodecUtil {

    private static final Logger logger = LoggerFactory.getLogger(CodecUtil.class);


    /**
     * 将 URL 解码
     */
    public static String decodeURL(String str) {
        String target;
        try {
            target = URLDecoder.decode(str, ConfigConstant.UTF_8);
        } catch (Exception e) {
            logger.error("解码出错！", e);
            throw new RuntimeException(e);
        }
        return target;
    }

}
