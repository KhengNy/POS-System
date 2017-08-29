package api;

/**
 * Created by khengny on 6/22/17.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

//    @Bean
//    public FilterRegistrationBean jWTAuthenticationFilter() {
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new JWTAuthenticationFilter());
//        registrationBean.addUrlPatterns("/api/*");
//
//        return registrationBean;
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
