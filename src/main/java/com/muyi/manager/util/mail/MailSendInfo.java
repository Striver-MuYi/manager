package com.muyi.manager.util.mail;

import java.util.Properties;

/**
 * description： 设置邮件发送信息实体类
 * Create By  ： sena104
 * Create Time： Created in 2021-06-18 15:34
 */

// 邮件发送信息
// 不支持发带附件的邮件
public class MailSendInfo {

    // 邮件发送服务器IP
    private String mailServerHost;
    private String mailServerPort;
    // 发件人地址
    private String formAddress;
    // 收件人地址
    private String toAddress;
    // 登陆邮件发送服务器的用户名和密码
    private String userName;
    private String password;
    // 是否需要身份认证
    private boolean validate = false;
    // 邮件标题
    private String subject;
    // 邮件内容
    private String content;

    public Properties getProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host",this.mailServerHost);
        properties.put("mail.smtp.port",this.mailServerPort);
        properties.put("mail.smtp.auth",validate ? "true" : "false");
        return properties;
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getFormAddress() {
        return formAddress;
    }

    public void setFormAddress(String formAddress) {
        this.formAddress = formAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
