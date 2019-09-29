package cn.eleven.provider;


import cn.eleven.api.SomeService;

public class SomeServiceImpl implements SomeService {
    @Override
    public String hello(String name) {
        System.out.println(name + "，我是提供者");
        return "Hello World! " + name;
    }

}
