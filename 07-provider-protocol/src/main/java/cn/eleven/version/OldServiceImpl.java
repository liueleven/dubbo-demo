package cn.eleven.version;


import cn.eleven.api.SomeService;

public class OldServiceImpl implements SomeService {
    @Override
    public String hello(String name) {
        System.out.println("使用rmi协议");
        return "rmi协议";
    }

}
