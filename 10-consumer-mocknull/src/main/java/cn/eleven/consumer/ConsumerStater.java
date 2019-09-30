package cn.eleven.consumer;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerStater {
    public static void main(String[] args) {
        System.out.println("服务消费启动");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        UserService userService = (UserService) ac.getBean("userService");
        String usernameById = userService.getUsernameById(1);
        // 服务降级，假设提供者挂了，这里返回null，而不是报错
        System.out.println("usernameById:" + usernameById);
    }

}
