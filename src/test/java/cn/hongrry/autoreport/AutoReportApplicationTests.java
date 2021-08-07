package cn.hongrry.autoreport;

import cn.hongrry.autoreport.service.AutoReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoReportApplicationTests {
    @Autowired
    AutoReportService service;
    @Test
    void contextLoads() {
        service.updateRecord();
    }


}
