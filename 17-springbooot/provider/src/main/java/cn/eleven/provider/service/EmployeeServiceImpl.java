package cn.eleven.provider.service;


import cn.eleven.commons.bean.Employee;
import cn.eleven.commons.service.EmployeeService;
import cn.eleven.provider.dao.EmployeeDao;
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
        employeeDao.insertEmployee(employee);
    }

    /**
     * 这里存在缓存击穿问题
     * 过程分析：当线程A从缓存中获取数据，没有获取到，获取对象锁，再次获取还是没有，此时从数据库中查找，
     *         但是此时cpu片选的时间刚好到了，线程A进入就绪状态，此时线程B进来，从缓存中获取数据，没有获取到，试图获取对象锁
     *         由于是单例的，只能被阻塞，此时线程C、D进来也都会被阻塞，线程A获取到CPU片选时间，把之前查找到的数据放入缓存中，释放
     *         锁资源，此时线程B、C、D会拿到锁，再次从缓存中获取，这时就可以获取到数据直接返回，而不需要从数据库查找了
     *         这个解决方案叫做双重锁检查
     * @return
     */
    @Override
    public Integer findEmployeeCount() {
        BoundValueOperations<Object, Object> ops = redisTemplate.boundValueOps("count");
        Object count =  ops.get();
        if (count == null) {
            synchronized (this) {
                count =  ops.get();
                if(count == null) {
                    System.out.println("<=========== [findEmployeeCount] 缓存没有，从数据库中查询");
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
