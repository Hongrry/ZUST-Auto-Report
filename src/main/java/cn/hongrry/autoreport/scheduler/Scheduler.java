package cn.hongrry.autoreport.scheduler;
import cn.hongrry.autoreport.constant.Messages;
import cn.hongrry.autoreport.expection.AutoReportException;
import cn.hongrry.autoreport.service.AutoReportService;
import cn.hongrry.autoreport.utils.DateUtils;
import cn.hongrry.autoreport.utils.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @author Hongrry
 * @create 2021-08-03 17:57
 */
@Component
public class Scheduler {
    private final static Logger logger = LoggerFactory.getLogger(Scheduler.class);
    private JavaMailSenderImpl mailSender;
    private AutoReportService autoReportService;
    @Autowired
    public void setUpdateService(AutoReportService autoReportService) {
        this.autoReportService = autoReportService;
    }

    @Autowired
    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * 每隔20分钟 刷新session
     */
    @Scheduled(cron = "0 0,20,40 * * * ?")
    public void wakeUpSession() {
        try {
            autoReportService.checkSession();
            logger.info(Messages.VALID);
        } catch (AutoReportException e) {
            mailSender.send(MailUtil.autoReportMessage(DateUtils.getSimpleDate(new Date()) + " "+ e.getMessage()));
            logger.error(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 每天0:10点更新
     */
    @Scheduled(cron = "0 10 0 * * ?")
    public void update() {
        String msg=autoReportService.updateRecord();
        mailSender.send(MailUtil.autoReportMessage(msg));
    }
}


