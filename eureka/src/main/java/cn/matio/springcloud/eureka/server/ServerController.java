package cn.matio.springcloud.eureka.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("server")
    public String server() {
        return "this is server, port is " + port;
    }

}
