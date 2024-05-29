package com.hanjx369.demo.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品实体类
 *
 * @author 寒江雪
 * @createDate 2024-05-29 23:28
 */
@Data
@Builder
public class Merchandise {

    /**
     * 商品ID
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

}
