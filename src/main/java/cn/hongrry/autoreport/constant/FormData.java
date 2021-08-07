package cn.hongrry.autoreport.constant;
import cn.hongrry.autoreport.utils.DateUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Hongrry
 * @create 2021-08-03 19:43
 */
@Component
@ConfigurationProperties(prefix = FormData.PROJECT_PREFIX)
public class FormData {
    public static final String PROJECT_PREFIX = "formdata";
    private Integer r_id;
    private String student_id;
    private String state;
    private String is_body_ok;
    private String is_gl;
    private String is_tl;
    private String is_jc;
    private String is_2_man;
    private String is_family;
    private String user_location;
    private String location_province;
    private String location_city;
    private String location_country;
    private String morning_state;
    private String morning_temperature;
    private String afternoon_state;
    private String is_jkm;
    private String longitude;
    private String latitude;
    private String uid;
    private String session;

    public String getR_id() {
        return r_id.toString();
    }

    public void setR_id(int r_id) {
         this.r_id = r_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
         this.student_id = student_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
         this.state = state;
    }

    public String getIs_body_ok() {
        return is_body_ok;
    }

    public void setIs_body_ok(String is_body_ok) {
         this.is_body_ok = is_body_ok;
    }

    public String getIs_gl() {
        return is_gl;
    }

    public void setIs_gl(String is_gl) {
         this.is_gl = is_gl;
    }

    public String getIs_tl() {
        return is_tl;
    }

    public void setIs_tl(String is_tl) {
         this.is_tl = is_tl;
    }

    public String getIs_jc() {
        return is_jc;
    }

    public void setIs_jc(String is_jc) {
         this.is_jc = is_jc;
    }

    public String getIs_2_man() {
        return is_2_man;
    }

    public void setIs_2_man(String is_2_man) {
         this.is_2_man = is_2_man;
    }

    public String getIs_family() {
        return is_family;
    }

    public void setIs_family(String is_family) {
         this.is_family = is_family;
    }

    public String getUser_location() {
        return user_location;
    }

    public void setUser_location(String user_location) {
         this.user_location = user_location;
    }

    public String getLocation_province() {
        return location_province;
    }

    public void setLocation_province(String location_province) {
         this.location_province = location_province;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
         this.location_city = location_city;
    }

    public String getLocation_country() {
        return location_country;
    }

    public void setLocation_country(String location_country) {
         this.location_country = location_country;
    }

    public String getMorning_state() {
        return morning_state;
    }

    public void setMorning_state(String morning_state) {
         this.morning_state = morning_state;
    }

    public String getMorning_temperature() {
        return morning_temperature;
    }

    public void setMorning_temperature(String morning_temperature) {
         this.morning_temperature = morning_temperature;
    }

    public String getAfternoon_state() {
        return afternoon_state;
    }

    public void setAfternoon_state(String afternoon_state) {
         this.afternoon_state = afternoon_state;
    }

    public String getIs_jkm() {
        return is_jkm;
    }

    public void setIs_jkm(String is_jkm) {
         this.is_jkm = is_jkm;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
         this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
         this.latitude = latitude;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
         this.uid = uid;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
         this.session = session;
    }
}
