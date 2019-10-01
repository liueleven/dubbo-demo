# 案例上手Dubbo

1. 01-api，这是公共业务接口
2. 01-consumer,01-provider 演示服务提供者和消费者的调用，直连式，不使用注册中心
3. 02-consumer-zk，02-provider-zk 演示服务提供者和消费者的调用。使用zk作为注册中心
4. 03-dubbo-admin，dubbo的管控平台
5. 04-consumer-zk，服务检查机制
6. 05-consumer-version，05-provider-version 版本控制
7. 06-consumer-group，06-consumer-group 分组功能
8. 07-consumer-protocol，07-provider-protocol 指定协议
9. 08-provider-zk01，08-provider-zk02，08-provider-zk03，08-consumer-load-balance 负载均衡演示
10. 09-provider-tolerance 容错重试
11. 10-consumer-mocknull 演示降级，值返回null；10-consumer-mockclass演示降级，值返回自定义内容
12. 11-provider-timeout,11-consumer-timeout超时机制，消费者配置优先级高于生产者
13. 12-limit 服务限流
14. 13-consumer-cache 声明式缓存，将结果缓存在消费者端
15. 14-consumer-registers，14-consumer-registers 使用多注册中心