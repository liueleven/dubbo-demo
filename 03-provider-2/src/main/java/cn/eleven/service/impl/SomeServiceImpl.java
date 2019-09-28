package cn.eleven.service.impl;

import cn.eleven.service.SomeService;

/**
 * @description: 一定要写注释啊
 * @date: 2019-09-27 21:20
 * @author: 十一
 */
public class SomeServiceImpl implements SomeService {
    public String hello(String msg) {
        return "Hello Dubbo! " + msg;
    }
}
