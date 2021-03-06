package eureka.colony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Server8100 {

    public static void main(String[] args) {
        SpringApplication.run(Server8100.class, args);
    }

}
