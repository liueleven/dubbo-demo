package cn.eleven.async;


import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 异步调用
 */
public class ConsumerAsyncStater2 {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        System.out.println("服务消费启动");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        SomeService service = (SomeService) ac.getBean("someService");

        long start = System.currentTimeMillis();
        String doThird = service.doThird();
        System.out.println("doThird 返回值：" + doThird);
        Future<String> thridFuture = RpcContext.getContext().getFuture();

        String doFourth = service.doFourth();
        System.out.println("doFourth 返回值：" + doFourth);
        Future<String> fourthFuture = RpcContext.getContext().getFuture();

        // Future这里获取值会被阻塞住，它利用的是轮询机制，轮询浪费cpu资源，而且不够及时
        System.out.println("doThird 异步返回值：" + thridFuture.get());
        System.out.println("doFourth 异步返回值：" + fourthFuture.get());


        System.out.println("<======== 共耗时：" + (System.currentTimeMillis() - start) + " ms");
    }

}
