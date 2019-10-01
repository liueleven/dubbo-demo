package cn.eleven.commons.service;

import cn.eleven.commons.bean.Employee;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-01 15:49
 * @author: 十一
 */
public interface EmployeeService {


    public void addEmployee(Employee employee);

    Integer findEmployeeCount();

    Employee findEmployeeById(Integer id);
}
