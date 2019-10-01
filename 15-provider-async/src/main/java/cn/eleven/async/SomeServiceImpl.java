package cn.eleven.async;

import java.util.concurrent.TimeUnit;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-01 14:07
 * @author: 十一
 */
public class SomeServiceImpl implements SomeService {

    public void sleep(String name,int time) {

        try {
            System.out.println("方法名：" + name + ", 休眠：" + time + " s");
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Override
    public String doFirst() {
        sleep("doFirst",2);
        return "doFirst";
    }

    @Override
    public String doSecond() {
        sleep("doSecond",3);
        return "doSecond";
    }

    @Override
    public String doThird() {
        sleep("doThird",4);
        return "doThird";
    }

    @Override
    public String doFourth() {
        sleep("doFourth",5);
        return "doFourth";
    }
}
