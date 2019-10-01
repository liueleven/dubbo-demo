package cn.eleven.async;

import java.util.concurrent.CompletableFuture;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-01 14:05
 * @author: 十一
 */
public interface SomeService {

    String doFirst();
    String doSecond();
    CompletableFuture<String> doThird();
    CompletableFuture<String> doFourth();
}
