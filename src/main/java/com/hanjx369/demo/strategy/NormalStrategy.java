package com.hanjx369.demo.strategy;

import com.alibaba.fastjson2.JSON;
import com.hanjx369.demo.entity.Merchandise;
import com.hanjx369.demo.entity.User;
import com.hanjx369.demo.enums.DiscountEnum;
import com.hanjx369.demo.strategy.context.ShoppingStrategyAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 普通用户策略
 *
 * @author 寒江雪
 * @createDate 2024-05-30 00:13
 */
@Slf4j
@Component
public class NormalStrategy implements ShoppingStrategyAware {

    @Override
    public DiscountEnum getStrategy() {
        log.info("load strategy: {}", JSON.toJSONString(DiscountEnum.NORMAL));
        return DiscountEnum.NORMAL;
    }

    @Override
    public Map<String, Object> buy(User user, Merchandise merchandise) {
        log.info("current strategy: {}", getStrategy().getType());
        DecimalFormat df = new DecimalFormat("0.00");
        Map<String, Object> result = new HashMap<>();
        result.put("用户姓名", user.getName());
        result.put("商品名称", merchandise.getName());
        result.put("商品原价", df.format(merchandise.getPrice()));
        result.put("折后价格", df.format(merchandise.getPrice().multiply(getStrategy().getDiscount())));
        return result;
    }
}
