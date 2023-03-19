package md.finance.financemd;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FinancemdApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinancemdApplication.class, args);

    }

}
