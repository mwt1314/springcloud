package eureka.colony;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("member")
    public String member() {
        return "member";
    }



}
