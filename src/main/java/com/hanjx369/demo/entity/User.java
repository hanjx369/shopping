package com.hanjx369.demo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 用户实体类
 *
 * @author 寒江雪
 * @createDate 2024-05-29 22:40
 */
@Data
@Builder
public class User {

    /**
     * ID
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String gender;
    /**
     * 用户类型 0 普通用户 1 普通VIP 2 高级VIP 3 至尊VIP 4 超级VIP
     */
    private Integer type;

}
