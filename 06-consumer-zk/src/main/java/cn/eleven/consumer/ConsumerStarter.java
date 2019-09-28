package cn.eleven.consumer;


import cn.eleven.service.SomeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @description: 一定要写注释啊
 * @date: 2019-09-27 21:23
 * @author: 十一
 */
public class ConsumerStarter {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-consumer.xml");
        SomeService someService = (SomeService) context.getBean("someService");
        String hello = someService.hello("Learn");
        System.out.println(hello);
    }
}
