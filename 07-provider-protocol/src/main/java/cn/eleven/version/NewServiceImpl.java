package cn.eleven.version;


import cn.eleven.api.SomeService;

public class NewServiceImpl implements SomeService {
    @Override
    public String hello(String name) {
        System.out.println("使用dubbo协议");
        return "dubbo协议";
    }

}
