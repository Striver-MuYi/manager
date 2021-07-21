package com.muyi.manager.util.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * description： 创建邮件服务器连接
 * Create By  ： sena104
 * Create Time： Created in 2021-06-18 15:34
 */
public class MyAuthenticator extends Authenticator {

    private String mailUserName;
    private String mailPassword;

    public MyAuthenticator() {

    }

    public MyAuthenticator(String mailUserName, String mailPassword) {
        this.mailUserName = mailUserName;
        this.mailPassword = mailPassword;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(mailUserName, mailPassword);
    }
}
