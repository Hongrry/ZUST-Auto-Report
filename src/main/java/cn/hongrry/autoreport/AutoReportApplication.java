package cn.hongrry.autoreport;
import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author HONGRRY
 */
@SpringBootApplication
@ForestScan("cn.hongrry.autoreport.client")
@EnableScheduling
public class AutoReportApplication implements CommandLineRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AutoReportApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
