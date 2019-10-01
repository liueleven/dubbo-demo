package cn.eleven.group;


import cn.eleven.api.SomeService;

public class AliPayServiceImpl implements SomeService {
    @Override
    public String hello(String name) {
        System.out.println("使用支付宝支付");
        return "AliPayServiceImpl-使用支付宝支付-"+name;
    }

}
