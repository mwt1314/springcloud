package eureka.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    //解决异常
    //Field restTemplate in eureka.order.OrderController required a bean of type 'org.springframework.web.client.RestTemplate' that could not be found.
    @Bean
    @LoadBalanced  //本地负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
