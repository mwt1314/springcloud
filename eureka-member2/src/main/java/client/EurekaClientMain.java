package client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 将当前服务注册到eureka上
 */
@SpringBootApplication()
@EnableEurekaClient
public class EurekaClientMain {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientMain.class, args);
    }

}