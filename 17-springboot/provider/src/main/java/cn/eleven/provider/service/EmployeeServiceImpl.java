package cn.eleven.provider.service;

import cn.eleven.bean.Employee;
import cn.eleven.provider.dao.EmployeeDao;
import cn.eleven.service.EmployeeService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @description: @Service dubbo 注解
 * @date: 2019-10-01 16:13
 * @author: 十一
 */
@Component
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;


    /**
     * @CacheEvict(value = "realTimeCache",allEntries = true) 当有对象插入时，清空realTimeCache所有缓存
     * @param employee
     */
    @CacheEvict(value = "realTimeCache",allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addEmployee(Employee employee) {
        employeeDao.insert(employee);
    }

    @Override
    public Integer findEmployeeCount() {
        BoundValueOperations<Object, Object> ops = redisTemplate.boundValueOps("count");
        Object count =  ops.get();
        if (count == null) {
            synchronized (this) {
                System.out.println("<=========== [findEmployeeCount] 缓存没有，从数据库中查询");
                if(count == null) {
                    count = employeeDao.selectEmployeeCount();
                    // 查询结果重新缓存到redis
                    ops.set(count,10, TimeUnit.SECONDS);
                }
            }
            return ((Integer) count);
        }
        return ((Integer) count);
    }

    /**
     * @Cacheable(value = "realTimeCache",key = "'employee_'+#id")
     * 如果缓存没有回去数据库中查询，再将将查询结果保存到realTimeCache中，key是employee_id，id是动态的
     *
     * @param id
     * @return
     */
    @Cacheable(value = "realTimeCache",key = "'employee_'+#id")
    @Override
    public Employee findEmployeeById(Integer id) {
        System.out.println("<=========== [findEmployeeById] 缓存没有，从数据库中查询，id：" + id);
        return employeeDao.selectEmployeeById(id);
    }
}
