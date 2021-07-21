package com.muyi.manager.util.mail;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

/**
 * description： 邮件发送工具类
 * Create By  ： sena104
 * Create Time： Created in 2021-06-18 15:33
 */
public class MailUtil {

    private final static String messageType = "text/html;charset=UTF-8";//相应内容类型，编码类型

    /**
     * description: 发送HTML邮件
     * create by: sena104
     * create time: 2021-06-18 15:17
     * @param
     * @return
     * @throws
     *
     */
    public static boolean sendHtmlMail(MailSendInfo mailSendInfo) {

        MyAuthenticator myAuthenticator = null;
        try {
            // 创建一个配置文件并保存
            Properties properties = mailSendInfo.getProperties();
            if (mailSendInfo.isValidate()) {
                myAuthenticator = new MyAuthenticator(mailSendInfo.getUserName(), mailSendInfo.getPassword());
            }
            // 创建一个session对象
            Session sendMailSession = Session.getInstance(properties, myAuthenticator);

            Message message = new MimeMessage(sendMailSession);
            // 发件人地址
            Address address = new InternetAddress(mailSendInfo.getFormAddress());
            message.setFrom(address);
            // 收件人地址
            Address to = new InternetAddress(mailSendInfo.getToAddress());
            // Message.RecipientType.TO属性表示接收者的类型为TO
            message.setRecipient(Message.RecipientType.TO, to);
            // 邮件标题
            message.setSubject(mailSendInfo.getSubject());
            // 邮件时间
            message.setSentDate(new Date());
            // 发送HTML格式邮件
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart multipart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(mailSendInfo.getContent(), messageType);
            multipart.addBodyPart(html);
            message.setContent(multipart);
            // 邮件发送
            Transport.send(message);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean sendTextMail(MailSendInfo mailSendInfo) {
        MyAuthenticator myAuthenticator = null;
        try {
            Properties properties = mailSendInfo.getProperties();
            if (mailSendInfo.isValidate()) {
                myAuthenticator = new MyAuthenticator(mailSendInfo.getUserName(), mailSendInfo.getPassword());
            }
            // 创建session对象
            Session session = Session.getInstance(properties, myAuthenticator);
            // 邮件对象
            Message message = new MimeMessage(session);
            // 发件人地址
            Address address = new InternetAddress(mailSendInfo.getFormAddress());
            message.setFrom(address);
            // 收件人地址
            Address to = new InternetAddress(mailSendInfo.getToAddress());
            message.setRecipient(Message.RecipientType.TO, to); // 单发邮件
            /* 群发邮件
            Address[] tos = new Address[0];
            message.setRecipients(Message.RecipientType.TO, tos);
             */
            // 邮件标题
            message.setSubject(mailSendInfo.getSubject());
            // 邮件时间
            message.setSentDate(new Date());
            // 邮件内容
            message.setContent(mailSendInfo.getContent(), messageType);
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
