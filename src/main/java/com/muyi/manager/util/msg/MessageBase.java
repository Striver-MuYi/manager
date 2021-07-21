package com.muyi.manager.util.msg;

/**
 * description： 基本返回格式
 * Create By  ： sena104
 * Create Time： Created in 2021-05-26 17:25
 */
public class MessageBase implements Message{

    private String code = MessageFactory.CODE_ERROR_400;
    private boolean success = false;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
