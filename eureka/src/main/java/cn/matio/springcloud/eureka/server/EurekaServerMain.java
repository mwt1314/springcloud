package cn.matio.springcloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author mawt
 * @description
 * @date 2019/12/25
 */
@SpringBootApplication
@EnableEurekaServer  //创建服务注册中心
public class EurekaServerMain {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain.class, args);
    }

}
