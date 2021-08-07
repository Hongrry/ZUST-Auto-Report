package cn.hongrry.autoreport.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * @author Hongrry
 * @create 2021-08-03 21:47
 */
@Component
public class MailUtil {
    private static String addressee;
    private static  String sender;

    @Value("${spring.mail.username}")
    public void setSender(String sender) {
        MailUtil.sender = sender;
    }
    @Value("${addressee}")
    public  void setAddressee(String addressee) {
        MailUtil.addressee = addressee;
    }

    public static SimpleMailMessage autoReportMessage(String text) {
       return simpleMailMessage(
                "疫情自动打卡-状态通知",
                text,
                addressee,
                sender);

    }

    public static SimpleMailMessage simpleMailMessage(
            String subject,
            String text,
            String addressee,
            String sender) {
        //简单邮件
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件标题
        message.setSubject(subject);
        // 设置邮件内容
        message.setText(text);
        // 设置邮件收信人
        message.setTo(addressee);
        // 设置邮件发信人
        message.setFrom(sender);

        return message;
    }
}
