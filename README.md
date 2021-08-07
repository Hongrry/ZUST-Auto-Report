# Auot-Report

**无法绕过微信 OAuth2 验证，该项目无法正常持续运行**
**依赖**

| Name                       | Version       |      |
| -------------------------- | ------------- | ---- |
| spring-boot-starter        | 2.3.7.RELEASE |      |
| forest-spring-boot-starter | 1.5.2-BETA    |      |
| jackson                    | 2.9.10        |      |
| spring-boot-starter-mail   | 2.3.7.RELEASE |      |

**使用方法**

在 `application.yml` 填入表单信息，只需要改有注释的地方

```yaml
formdata:
  student_id: 1190xxxxxx   					# 学号
  state: 1
  is_body_ok: 1
  is_gl: 0
  is_tl: 0
  is_jc: 0
  is_2_man: 0
  is_family: 0
  user_location: 1
  location_province: xx省  # 所在省 
  location_city: xx市  # 所在市
  location_country: xx县 # 所在县
  morning_state: 1
  morning_temperature:
  afternoon_state: 1
  afternoon_temperature:
  is_jkm: 1
  longitude: xxxxx  # 所在地经度
  latitude: xxxxx # 所在地纬度
  uid: 1190xxxx # 学号
  session: xxxxxx # 会话 session
```

其中， **session 需要抓包获取**微信 OAuth2 验证后，服务器返回的 session，目前测试大概有效期在 **两个小时** 左右

在 `application.properties` 配置邮件通知

```properties
spring.mail.username=admin@miooim.cn    # 发件人
spring.mail.password=xxxx   # 密码
spring.mail.host=smtp.exmail.qq.com # 主机
# qq需要配置ssl
spring.mail.properties.mail.smtp.ssl.enable=true
logging.file.name=auto.log  # 日志输出文件
addressee=xxxxx@qq.com # 收件人邮箱
```

默认每天凌晨 00:10 打卡，可在 `Scheduler.java` 内以 cron 表达式的形式修改定时任务

```java
/**
 * 每天0:10点更新
 */
@Scheduled(cron = "0 10 0 * * ?")
public void update() {
    String msg=autoReportService.updateRecord();
    mailSender.send(MailUtil.autoReportMessage(msg));
}
```

最后，执行 package 打包，放服务器运行 jar

