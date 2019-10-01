package cn.eleven.async;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 异步调用
 */
public class ConsumerAsyncStater {
    public static void main(String[] args) throws IOException {
        System.out.println("服务消费启动");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        SomeService service = (SomeService) ac.getBean("someService");

        long start = System.currentTimeMillis();
        service.doThird();
        service.doFourth();
        System.out.println("<======== 共耗时：" + (System.currentTimeMillis() - start) + " ms");
    }

}
