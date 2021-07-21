package com.muyi.manager.util.msg;

/**
 * description： 消息工厂
 * Create By  ： sena104
 * Create Time： Created in 2021-05-26 17:31
 */
public class MessageFactory {

    public static final String CODE_SUCCESS = "0";
    public static final String CODE_ERROR_400 = "400";
    public static final String CODE_ERROR_401 = "401";  //未授权

    public static final String MSG_TYPE_BASE = "base";
    public static final String MSG_TYPE_DATA = "data";
    public static final String MSG_TYPE_PAGE = "page";

    public static Message build(String type) {
        Message msg = null;
        if (type.equals(MSG_TYPE_BASE)) {
            msg = new MessageBase();
        } else if (type.equals(MSG_TYPE_DATA)) {
            msg = new MessageData();
        } else if (type.equals(MSG_TYPE_PAGE)) {
            msg = new MessagePage();
        }
        return msg;
    }

    public static MessageBase buildBase() {
        return (MessageBase) build(MSG_TYPE_BASE);
    }

    public static MessageData buildData() {
        return (MessageData) build(MSG_TYPE_DATA);
    }

    public static MessagePage buildPage() {
        return (MessagePage) build(MSG_TYPE_PAGE);
    }

}
