package cn.eleven.provider;


import cn.eleven.api.SomeService;

public class SomeServiceImpl implements SomeService {
    @Override
    public String hello(String name) {
        System.out.println(name + "，第二个服务提供者");
        return "第二个服务提供者";
    }

}
