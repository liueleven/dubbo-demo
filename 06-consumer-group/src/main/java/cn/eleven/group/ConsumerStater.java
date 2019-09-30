package cn.eleven.group;


import cn.eleven.api.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerStater {
    public static void main(String[] args) {
        System.out.println("服务消费启动");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        SomeService weiXinService = (SomeService) ac.getBean("weiXinService");
        String weiXin = weiXinService.hello("weiXin");
        System.out.println(weiXin);

        SomeService aliService = (SomeService) ac.getBean("aliService");
        String ali = aliService.hello("ali");
        System.out.println(ali);

    }

}
