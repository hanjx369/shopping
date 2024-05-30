package com.hanjx369.demo.strategy.factory;

import com.hanjx369.demo.enums.DiscountEnum;
import com.hanjx369.demo.strategy.context.ShoppingStrategyAware;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 寒江雪
 * @createDate 2024-05-29 23:58
 */
@Slf4j
@Component
public class ShoppingFactory {

    @Resource
    private List<ShoppingStrategyAware> shoppingStrategies;

    private final Map<DiscountEnum, ShoppingStrategyAware> shoppingMap = new HashMap<>();

    /**
     * 根据code获取折扣策略
     *
     * @param code code
     * @return DiscountEnum
     */
    public ShoppingStrategyAware getStrategy(int code) {
        DiscountEnum discountEnum = DiscountEnum.valueOf(code);
        return shoppingMap.get(discountEnum);
    }

    /**
     * 注册策略枚举
     */
    @PostConstruct
    public void register() {
        shoppingStrategies.forEach(shoppingStrategy -> {
            DiscountEnum discount = shoppingStrategy.getStrategy();
            shoppingMap.put(discount, shoppingStrategy);
        });
    }
}
