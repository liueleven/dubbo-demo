package cn.eleven.provider;



import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * @description: @EnableDubboConfiguration 需要开启dubbo注解配置
 * @date: 2019-10-01 15:57
 * @author: 十一
 */
@EnableTransactionManagement
@SpringBootApplication
@EnableCaching
@EnableDubboConfiguration   // 开启Dubbo自动配置功能
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }

}
