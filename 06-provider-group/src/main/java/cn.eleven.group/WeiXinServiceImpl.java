package cn.eleven.group;


import cn.eleven.api.SomeService;

public class WeiXinServiceImpl implements SomeService {
    @Override
    public String hello(String name) {
        System.out.println("使用微信支付");
        return "WeiXinServiceImpl-使用微信支付-"+name;
    }

}
