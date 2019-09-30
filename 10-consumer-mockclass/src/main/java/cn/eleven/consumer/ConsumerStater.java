package cn.eleven.consumer;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerStater {
    public static void main(String[] args) {
        System.out.println("服务消费启动");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-consumer.xml");
        UserService userService = (UserService) ac.getBean("userService");
        // 调用失败，返回返回UserServiceMock.getUsernameById中的内容
        String usernameById = userService.getUsernameById(1);
        System.out.println("usernameById:" + usernameById);

        // 添加失败，返回UserServiceMock.addUser中的内容
        userService.addUser("Dubbo");
    }

}
