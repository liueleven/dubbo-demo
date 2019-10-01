package cn.eleven.consumer;


import cn.eleven.api.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerStater {
    public static void main(String[] args) {
        System.out.println("服务消费启动");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        SomeService service = (SomeService) ac.getBean("someService");
        // 会缓存1000次调用次数
        for (int i=1; i<=1000; i++) {
            System.out.println(service.hello("Dubbo----" + i));
        }
        // 当调用这个时，会用LRU算法，清除Dubbo----1
        System.out.println(service.hello("Dubbo----B"));
        // 当调用这个时，会重新调用，因为Dubbo----1已经被清除了，可以在provider控制台中看到调用情况
        System.out.println(service.hello("Dubbo----1"));
        // 当调用这个时，会直接从缓存中获取
        System.out.println(service.hello("Dubbo----3"));
    }

}
