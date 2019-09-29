package cn.eleven.provider;


import org.apache.dubbo.container.Main;

import java.io.IOException;

public class ProviderStater {
    public static void main(String[] args) throws IOException {
        // dubbo依赖于spring环境，使用Main.main会帮我们起一个不耗资源的spring容器
        Main.main(args);
    }
}
