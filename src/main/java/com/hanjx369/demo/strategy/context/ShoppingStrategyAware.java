package com.hanjx369.demo.strategy.context;

import com.hanjx369.demo.entity.Merchandise;
import com.hanjx369.demo.entity.User;
import com.hanjx369.demo.enums.DiscountEnum;

import java.util.Map;

/**
 * @author 寒江雪
 * @createDate 2024-05-29 23:56
 */
public interface ShoppingStrategyAware {

    /**
     * 返回应享折扣枚举
     *
     * @return 折扣
     */
    DiscountEnum getStrategy();

    /**
     * 购买
     *
     * @param user        用户
     * @param merchandise 商品
     * @return 结果
     */
    Map<String, Object> buy(User user, Merchandise merchandise);
}
