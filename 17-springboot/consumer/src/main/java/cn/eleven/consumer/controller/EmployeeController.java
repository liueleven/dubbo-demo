package cn.eleven.consumer.controller;

import cn.eleven.bean.Employee;
import cn.eleven.service.EmployeeService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-01 16:39
 * @author: 十一
 */
@Controller
@RequestMapping("/consumer/employee")
public class EmployeeController {

    @Reference
    private EmployeeService employeeService;

    @PostMapping("/register")
    public String register(Employee employee, Model model) {
        employeeService.addEmployee(employee);
        model.addAttribute("employee",employee);
        return "/welcome.jsp";

    }

    @ResponseBody
    @RequestMapping("/find/{id}")
    public Employee find(@PathVariable("id") Integer id) {

        Employee employee = employeeService.findEmployeeById(id);
        return employee;
    }

    @RequestMapping("/count")
    @ResponseBody
    public Integer countHandle() {
        return employeeService.findEmployeeCount();
    }
}
