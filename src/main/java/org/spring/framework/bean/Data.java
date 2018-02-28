package org.spring.framework.bean;

/**
 * 返回数据对象
 *
 * @author jiangyixuan
 * @date 2018-02-28
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
