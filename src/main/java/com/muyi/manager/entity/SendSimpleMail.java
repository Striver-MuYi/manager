package com.muyi.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * description： 邮件发送实体
 * Create By  ： sena104
 * Create Time： Created in 2021-06-17 17:55
 */
@Data
public class SendSimpleMail {
    private Integer id;
    private String mailSubject;
    private String mailContent;
    private String[] tos;
}
