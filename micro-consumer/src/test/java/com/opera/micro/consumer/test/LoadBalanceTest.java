package com.opera.micro.consumer.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

import com.opera.micro.consumer.MicroConsumerApplication;

/**
 * Created by hanghang on 2019/9/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicroConsumerApplication.class)
public class LoadBalanceTest {
    @Autowired
    RibbonLoadBalancerClient client;
    @Test
    public void testRibbon(){
        for (int i = 0; i <100 ; i++) {
            ServiceInstance instance=this.client.choose("user-service-producer");
            System.out.println(instance.getHost()+":"+instance.getPort());
        }
    }
}
