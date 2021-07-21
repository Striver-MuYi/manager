package com.muyi.manager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muyi.manager.entity.SendSimpleMail;
import com.muyi.manager.mapper.SendSimpleMailMapper;
import com.muyi.manager.service.SendSimpleMailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * description： 发送邮件接口实现类
 * Create By  ： sena104
 * Create Time： Created in 2021-06-17 18:00
 */
@Service
@AllArgsConstructor
public class SendSimpleMailServiceImpl extends ServiceImpl<SendSimpleMailMapper, SendSimpleMail> implements SendSimpleMailService {

//    @Value("${spring.mail.username}")
//    private String form;

    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMail(SendSimpleMail sendSimpleMail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1967797748@qq.com");
        message.setSubject(sendSimpleMail.getMailSubject());
        message.setText(sendSimpleMail.getMailContent());
        message.setTo(sendSimpleMail.getTos());
        javaMailSender.send(message);
    }
}
