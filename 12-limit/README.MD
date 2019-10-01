## 服务限流
为了防止某个消费者的QPS或所有消费者的QPS总和突然飙升而导致的重要服务的
失效，系统可以对访问流量进行控制，这种对集群的保护措施称为服务限流。

## 直接限流
通过对连接数量直接进行限制来达到限流的目的
### executes
该属性仅能设置在**提供者**端。可以设置为接口级别，也可以设置为方法级别。限制的是 服务(方法)并发执行数量。
```$xslt
// 表示当前接口中的方法并发执行数不能超过10个
<dubbo:service interface="cn.eleven.xxxService" ref="xxxService" executes="10"/>

// 表示该接口的hello()方法并发执行数不能超过10个
<dubbo:service interface="cn.eleven.xxxService" ref="xxxService" executes="10">
    <dubbo:method name="hello" executes="10"/>
</dubbo:service>
```

### accepts
该属性仅可设置在**提供者**端的<dubbo:provider/>标签中，用于对指定协议的连接数量进行限制。
 ```$xslt
 // 表示该提供者在使用dubbo协议最多接收10个消费者连接
<dubbo:provider protocol="dubbo" accepts="10"/>
```
### actives
该限流方式可以设置在提供者端，也可以设置在消费者端。可以设置为接口级别，也可以设置为方法级别。

#### 提供者端限流
```$xslt
<dubbo:service interface="cn.eleven.xxxService" ref="xxxService" actives="10"/>
```
#### 消费者端限流
```$xslt
<dubbo:service interface="cn.eleven.xxxService" ref="xxxService" actives="10"/>
```
### connections
可以设置在提供者端，也可以设置在消费者端。限定连接的个数。对于短连接，该属性效果与actives相同。
但对于长连接，其限制的是长连接的个数。一般情况下，我们会使connectons与actives联用，让
connections限制长连接个数，让actives 限制一个长连接中可以处理的请求个数。

> 联用前提是使用默认的Dubbo服务暴露协议。

```$xslt
<dubbo:service interface="cn.eleven.xxxService" ref="xxxService" connections="10"/>
```
## 间接限流
通过一些非连接数量设置来达到限制流量的目的

### 延迟连接
仅可设置在消费者端，仅作用于Dubbo服务暴露协议。将长连接的建立推迟到消费者真正调用提供者时，
可以减少长连接的数量。

```$xslt
// 表示消费者连接该接口中的每个方法都采用延迟连接
<dubbo:service interface="cn.eleven.xxxService" id="xxxService" lazy="true"/>

// 表示消费者对所有方法发出的连接都采用延迟连接
<dubbo:consumer  lazy="true"/>
```

### 粘连连接
仅能设置在消费者端，可以设置为接口级别，也可以设置为方法级别。仅作用于Dubbo 务暴露协议。
会使客户端尽量向同一个提供者发起调用，除非该提供者挂了，才会连接另一台。只要启用了粘连连接，就会自动启用延迟连接。
它限制的是**流向**，而非流量。

```$xslt
// 表示当前消费者对指定接口的每一个方法都使用粘贴连接
<dubbo:service interface="cn.eleven.xxxService" id="xxxService" sticky="true"/>

// 表示当前消费者对指定接口的hello方法开启粘贴连接
<dubbo:service interface="cn.eleven.xxxService" id="xxxService" sticky="true">
    <dubbo:method name="hello" sticky="true"/>
</dubbo:service>
```

### 负载均衡
该方案也能达到限流的目的，限制的是**流向**，而不是流量