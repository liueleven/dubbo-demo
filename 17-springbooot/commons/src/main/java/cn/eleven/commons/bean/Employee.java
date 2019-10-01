package cn.eleven.commons.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 一定要写注释啊
 * @date: 2019-10-01 15:48
 * @author: 十一
 */
@Data
public class Employee implements Serializable {

    private Integer id;

    private String name;

    private int age;
}
