package cn.hongrry.autoreport.client;
import cn.hongrry.autoreport.constant.FormData;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Request;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * @author Hongrry
 * @create 2021-08-03 16:29
 */
@Component
public interface NcovClient {
    /**
     * 获取打卡信息
     * @param map
     * @return
     */
    @Request(url = "https://v-xxtb.zust.edu.cn/api/Ncov2019/get_my_record?"
            ,dataType = "json",
            headers = {
            "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36 NetType/WIFI MicroMessenger/7.0.20.1781(0x6700143B) WindowsWechat(0x63030073)"
            })
    Map<String,Object> getMyRecord(@Query Map<String, Object> map);

    /**
     * 检查 session是否过期
     * @param session
     * @param studentId
     * @return
     */
    @Request(
            url = "https://v-xxtb.zust.edu.cn/api/backschool/get_student_school_code",
            dataType = "json"
    )
    Map<String,Object> checkSession(@Query("session") String session, @Query("student_id") String studentId );

    /**
     * 更新打卡数据
     * @param formData
     * @return
     */
    @Request(
            url = "https://v-xxtb.zust.edu.cn/api/Ncov2019/update_record_student",
            dataType = "json",
            headers = {
            "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.138 Safari/537.36 NetType/WIFI MicroMessenger/7.0.20.1781(0x6700143B) WindowsWechat(0x63030073)"
            }
    )
    Map<String,Object> updateRecord(@Query FormData formData);

}
