package cn.eleven.version;


import cn.eleven.api.SomeService;

public class OldServiceImpl implements SomeService {
    @Override
    public String hello(String name) {
        System.out.println("执行老版本的代码 OldServiceImpl");
        return "OldServiceImpl";
    }

}
