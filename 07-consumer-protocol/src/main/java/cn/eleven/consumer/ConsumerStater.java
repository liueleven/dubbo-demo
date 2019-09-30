package cn.eleven.consumer;


import cn.eleven.api.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerStater {
    public static void main(String[] args) {
        System.out.println("服务消费启动");

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        SomeService oldService = (SomeService) ac.getBean("oldService");
        String dubbo = oldService.hello("oldService");
        System.out.println(dubbo);

        SomeService newService = (SomeService) ac.getBean("newService");
        String rmi = newService.hello("newService");
        System.out.println(rmi);
    }

}
