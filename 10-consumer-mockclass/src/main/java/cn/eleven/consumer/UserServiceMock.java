package cn.eleven.consumer;


/**
 * @description: 自定义返回值，类名是接口名+Mock结尾，并且在同一个包下，才可以
 * @date: 2019-09-30 17:53
 * @author: 十一
 */
public class UserServiceMock implements UserService {

    @Override
    public String getUsernameById(int id) {
        return "用户不存在，id：" + id;
    }

    @Override
    public void addUser(String username) {
        System.out.println("添加用户失败,username：" + username);
    }
}
