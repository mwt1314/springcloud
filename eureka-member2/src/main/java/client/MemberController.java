package client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/getMember")
    public String getMember() {

        return "this is member service, port is " + port;
    }

    @RequestMapping("/getMember2")
    public String getMember2() {

        return "this is member service, port is " + port;
    }

}
