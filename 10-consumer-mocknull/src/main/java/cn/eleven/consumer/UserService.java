package cn.eleven.consumer;

/**
 * @description: 一定要写注释啊
 * @date: 2019-09-30 17:53
 * @author: 十一
 */
public interface UserService {

    String getUsernameById(int id);
    void addUser(String username);
}
