package edu.xalead;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//包含@SpringBootApplication
//和@EnableDiscoveryClient
@EnableZuulProxy//启用zuul网关
@SpringCloudApplication
public class TaobaoGateWay {
    public static void main(String[] args) {
        SpringApplication.run(TaobaoGateWay.class);
    }
}
