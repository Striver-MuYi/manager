package com.muyi.manager.controller;

import com.muyi.manager.entity.SendSimpleMail;
import com.muyi.manager.service.SendSimpleMailService;
import com.muyi.manager.util.mail.MailSendInfo;
import com.muyi.manager.util.mail.MailUtil;
import com.muyi.manager.util.shortMsg.SmsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description： 邮件发送
 * Create By  ： sena104
 * Create Time： Created in 2021-06-17 14:37
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail/")
public class MailSendController {

    private final SendSimpleMailService sendSimpleMailService;

    @PostMapping("/simple")
    public void sendSimpleMail(@RequestBody SendSimpleMail sendSimpleMail){
        sendSimpleMailService.sendSimpleMail(sendSimpleMail);
    }

    public static void main(String[] args) {
        String html = "<div style=\"background: #f5f5f5;\">\n" +
                "        <h1 style=\"color: #FF5722;\">永恒传奇-zYang</h1>\n" +
                "        <p>大家好，我是智能z帅。</p>\n" +
                "        <h3 style=\"color: #FFB800;\">兄弟姐们，和我一起扫码领取杀猪刀吧，杀金猪爆装备。</h3>\n" +
                "        <h4 style=\"color: #1E9FFF;\">赢了我们会所按摩，输了我陪你搬砖干活</h4>\n" +
                "        <p>永不言弃，请叫我zYang帅锅，如有意向请添加<strong>v-x: cz357369</strong></p>\n" +
                "    </div>";
        String html1 = "<div style=\"background: #f5f5f5;\">\n" +
                "        <h1 style=\"color: #FF5722;\">永恒传奇-zYang</h1>\n" +
                "        <p>大家好，我是智能z帅。</p>\n" +
                "        <h3 style=\"color: #FFB800;\">\n" +
                "            兄弟姐们，和我一起扫码领取杀猪刀吧，杀金猪爆装备。夜夜暴富点击\n" +
                "            <a style=\"color: ;\" href=\"http://www.20gtt.com/\" target=\"_black\">http://www.20gtt.com/</a>\n" +
                "        </h3>\n" +
                "        <h4 style=\"color: #01AAED;\">赢了我们会所按摩，输了我陪你搬砖干活</h4>\n" +
                "        <p>永不言弃，请叫我zYang帅锅，如有意向请添加<strong>v-x: cz357369</strong></p>\n" +
                "    </div>";
        String html2 = "<div style=\"background: #f5f5f5;\">\n" +
                "        <h1 style=\"color: #FF5722;\">永恒传奇-zYang</h1>\n" +
                "        <p>大家好，我是智能z帅。</p>\n" +
                "        <h3 style=\"color: #FFB800;\">\n" +
                "            在受苦受难之际，我依然不弃。<br>\n" +
                "            在遭受函怪兽挑衅之际，我依然沉寂。<br>\n" +
                "            在函怪兽嚣张跋扈之际，我永不言弃。<br>\n" +
                "            我忍耐至今，死里逃生，拼尽全力。如今，我已到达天际，王者复仇。<br>\n" +
                "            挑战延农五期25栋最强怪兽——函怪兽（一个狰狞可怕，实力恐怖，嗜血残暴的恶魔）<br>\n" +
                "            为我而战，为25而起。授首吧！\n" +
                "        </h3>\n" +
                "        <h4 style=\"color: #01AAED;\">赢了我们会所按摩成就25栋最强，输了我陪你搬砖干活</h4>\n" +
                "        <p>永不言弃，请叫我zYang帅锅，如有意向请添加<strong>v-x: cz357369</strong></p>\n" +
                "    </div>";
        MailSendInfo info = new MailSendInfo();
        info.setMailServerHost("smtp.qq.com");
        // 使用SSL，端口号465或587
        info.setMailServerPort("25");
        info.setValidate(true);
        info.setFormAddress("1967797748@qq.com");
        // 收件人
        info.setToAddress("1829665969@qq.com");
//        info.setToAddress("1975463617@qq.com");

        info.setUserName("1967797748@qq.com");
        info.setPassword("dajxykvwabnqbiic");
//        info.setSubject("杀猪刀是带带相传的");
        info.setSubject("挑战最强怪兽 -- 函");
//        info.setContent(html1);
        info.setContent(html2);
//        boolean res = MailUtil.sendTextMail(info);
        boolean res = MailUtil.sendHtmlMail(info);
        if (res) {
            System.out.println("发送成功");
        } else {
            System.out.println("发送失败");
        }
        // 如果想使用指定的电子邮箱地址充当发送者，需要更换成特定电子邮箱服务器的主机地址以及端口号
//        mailInfo.setMailServerHost("61.144.222.5");
//        mailInfo.setMailServerPort("25");
    }
}
