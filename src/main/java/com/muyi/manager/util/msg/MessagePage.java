package com.muyi.manager.util.msg;

/**
 * description： 返回分页数据
 * Create By  ： sena104
 * Create Time： Created in 2021-05-26 17:36
 */
public class MessagePage extends MessageBase {

    private int total = 0;
    private Object row = null;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getRow() {
        return row;
    }

    public void setRow(Object row) {
        this.row = row;
    }
}
