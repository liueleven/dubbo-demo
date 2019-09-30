package cn.eleven.provider;


import cn.eleven.api.SomeService;

import java.util.Random;

public class SomeServiceImpl implements SomeService {

    @Override
    public String hello(String name) {
        try {
            int time = new Random().nextInt(50) * 1000;
            System.out.println("《====================name:"+Thread.currentThread().getName()+",time:" + time);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("《====================容错测试，我是提供者");
        return "Hello World! " + name;
    }

}
