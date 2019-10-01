package cn.eleven.async;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * 异步调用
 */
public class ConsumerAsyncStater {
    public static void main(String[] args) throws IOException {
        System.out.println("服务消费启动");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        SomeService service = (SomeService) ac.getBean("someService");

        long start = System.currentTimeMillis();
        CompletableFuture<String> third = service.doThird();
        CompletableFuture<String> fourth = service.doFourth();


        // CompletableFuture使用的是回调机制
        third.whenComplete((result,e) -> {
            if (e != null) {
                e.printStackTrace();
            }else {
                System.out.println("third 异步回调结果：" + result);
            }
        });
        fourth.whenComplete((result,e) -> {
            if (e != null) {
                e.printStackTrace();
            }else {
                System.out.println("fourth 异步回调结果：" + result);
            }
        });
        System.out.println("<======== 共耗时：" + (System.currentTimeMillis() - start) + " ms");
    }

}
