package com.muyi.manager.util.msg;

/**
 * description： 返回一条数据
 * Create By  ： sena104
 * Create Time： Created in 2021-05-26 17:36
 */
public class MessageData extends MessageBase {

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
