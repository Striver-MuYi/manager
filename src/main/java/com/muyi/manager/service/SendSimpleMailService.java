package com.muyi.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.muyi.manager.entity.SendSimpleMail;

/**
 * description： 发送邮件接口
 * Create By  ： sena104
 * Create Time： Created in 2021-06-17 17:59
 */
public interface SendSimpleMailService extends IService<SendSimpleMail> {

    void sendSimpleMail(SendSimpleMail sendSimpleMail);
}
