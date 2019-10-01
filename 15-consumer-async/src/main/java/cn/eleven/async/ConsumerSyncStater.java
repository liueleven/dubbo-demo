package cn.eleven.async;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 同步调用
 */
public class ConsumerSyncStater {
    public static void main(String[] args) throws IOException {
        System.out.println("服务消费启动");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        SomeService service = (SomeService) ac.getBean("someService");

        long start = System.currentTimeMillis();
        String first = service.doFirst();
        System.out.println("同步，doFirst 获取值：" + first);
        String second = service.doSecond();
        System.out.println("同步，doSecond 获取值：" + second);
        System.out.println("<======== 共耗时：" + (System.currentTimeMillis() - start) + " ms");
    }

}
