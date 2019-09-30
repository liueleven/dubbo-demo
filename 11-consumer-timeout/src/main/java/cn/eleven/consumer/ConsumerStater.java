package cn.eleven.consumer;


import cn.eleven.provider.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerStater {
    public static void main(String[] args) {
        System.out.println("服务消费启动");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        UserService userService = (UserService) ac.getBean("userService");
        // 如果超时，返回降级内容null，未超时返回：张三
        String hello = userService.getUsernameById(2);
        System.out.println("<============="+hello);
    }

}
