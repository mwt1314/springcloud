package eureka.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    /**
     * restTemplate由springboot的web组件提供的，默认整合了ribbon负载均衡器
     * rest底层采用了httpclient技术
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 在springcloud中有两种方式调用：rest和feign（springcloud）
     *
     * @return
     */
    @GetMapping("getOrder")
    public String getOrder() {
        return "order";
    }

    /**
     * 经测试，当加上@LoadedBalanced时
     * 报错了java.lang.IllegalStateException: No instances available for localhost
     * 需要使用服务别名的方式
     *
     * @return
     */
    @GetMapping("getOrder2")
    public String getOrder2() {
        //调用方式：1.采用服务别名调用，2直接调用
        String forObject = restTemplate.getForObject("http://localhost:8000/getMember", String.class);
        System.out.println("订单服务调用会员服务result=" + forObject);
        return "order reponse is:" + forObject;
    }

    /**
     * 使用服务别名的方式调用rest时：
     * 需要加上@LoadedBalanced（本地负载均衡）
     *
     * 当会员服务为集群时：
     * 会员服务8000：eureka-client模块名：返回值为order reponse is:this is member service, port is 8000
     * 会员服务8010：eureka-member2模块名：返回值为order reponse is:this is member service, port is 8010
     * 反复调用此方法时：会轮询调用他们
     *
     * @return
     */
    @GetMapping("getOrder3")
    public String getOrder3() {
        //调用方式：1.采用服务别名调用，2直接调用
        //使用别名去注册中心上获取对应的服务调用地址  ，使用该方式需要依赖ribbon，需要加上@LoadedBalanced
        String alias = "app-member";
        String forObject = restTemplate.getForObject("http://app-member/getMember", String.class);
        System.out.println("订单服务调用会员服务result=" + forObject);
        return "order reponse is:" + forObject;
    }

    /**
     * 经测试，当加上@LoadedBalanced时
     * java.lang.IllegalStateException: No instances available for 127.0.0.1
     *
     *
     * @return
     */
    @GetMapping("getOrder4")
    public String getOrder4() {
        //调用方式：1.采用服务别名调用，2直接调用
        String forObject = restTemplate.getForObject("http://127.0.0.1:8000/getMember", String.class);
        System.out.println("订单服务调用会员服务result=" + forObject);
        return "order reponse is:" + forObject;
    }

}
