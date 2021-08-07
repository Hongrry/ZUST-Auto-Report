package cn.hongrry.autoreport.service;

import cn.hongrry.autoreport.client.NcovClient;
import cn.hongrry.autoreport.constant.FormData;
import cn.hongrry.autoreport.constant.Messages;
import cn.hongrry.autoreport.expection.AutoReportException;
import cn.hongrry.autoreport.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Map;

/**
 * @author Hongrry
 * @create 2021-08-03 16:32
 */
@Service
public class AutoReportService {
    private NcovClient client;
    private FormData formData;


    @Autowired
    public void setClient(NcovClient client) {
        this.client = client;
    }

    @Autowired
    public void setFormData(FormData formData) {
        this.formData = formData;
    }

    public String updateRecord() {
        // 计算统计编号
        int RID = DateUtils.differentDaysByMillisecond(DateUtils.parsesDateString("2020-2-04"), new Date());
        formData.setR_id(RID);
        Map<String, Object> map = client.updateRecord(formData);

        // 邮件正文
        return map.toString();
    }

    public void checkSession() throws AutoReportException {
        Map<String, Object> map = client.checkSession(formData.getSession(), formData.getStudent_id());
        if (!map.get("code").equals(Messages.SUCCESS)) {
            throw new AutoReportException(map.toString());
        }

    }

}
