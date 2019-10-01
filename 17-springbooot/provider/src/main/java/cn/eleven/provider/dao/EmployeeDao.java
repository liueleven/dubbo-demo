package cn.eleven.provider.dao;


import cn.eleven.commons.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-01 16:13
 * @author: 十一
 */
@Mapper
public interface EmployeeDao {

    void insertEmployee(Employee employee);

    Integer selectEmployeeCount();

    Employee selectEmployeeById(int id);
}
