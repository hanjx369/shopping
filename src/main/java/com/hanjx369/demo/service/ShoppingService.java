package com.hanjx369.demo.service;

import java.util.Map;

/**
 * 购物服务
 *
 * @author 寒江雪
 * @createDate 2024-05-29 23:26
 */
public interface ShoppingService {

    /**
     * 购买
     *
     * @param userId        用户ID
     * @param merchandiseId 商品ID
     * @return 购买结果
     */
    Map<String, Object> buy(Long userId, Long merchandiseId);
}
