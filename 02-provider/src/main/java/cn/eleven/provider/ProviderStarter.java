package cn.eleven.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @description: 一定要写注释啊
 * @date: 2019-09-27 21:23
 * @author: 十一
 */
public class ProviderStarter {
    public static void main(String[] args) throws IOException {
        // 创建Spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-provider.xml");
        context.start();
        System.in.read();
    }
}
