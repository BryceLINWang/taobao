package edu.xalead;

import org.springframework.boot.SpringApplication;

import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringCloudApplication
@EnableEurekaClient
@MapperScan("edu.xalead.dao")
public class TaobaoItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaobaoItemApplication.class);
    }
}
