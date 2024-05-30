package com.hanjx369.demo.strategy;

import com.hanjx369.demo.entity.Merchandise;
import com.hanjx369.demo.entity.User;
import com.hanjx369.demo.enums.DiscountEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 高级vip策略
 *
 * @author 寒江雪
 * @createDate 2024-05-30 12:32
 */
@Slf4j
@Component
public class PVIPStrategy implements ShoppingStrategy {
    @Override
    public DiscountEnum getStrategy() {
        return DiscountEnum.PVIP;
    }

    @Override
    public Map<String, Object> buy(User user, Merchandise merchandise) {
        log.info("当前策略: {}", getStrategy().getType());
        DecimalFormat df = new DecimalFormat("0.00");
        Map<String, Object> result = new HashMap<>();
        result.put("用户姓名", user.getName());
        result.put("用户等级", getStrategy().getType());
        result.put("商品名称", merchandise.getName());
        result.put("商品原价", df.format(merchandise.getPrice()));
        result.put("应享折扣", df.format(getStrategy().getDiscount()));
        result.put("折后价格", df.format(merchandise.getPrice().multiply(getStrategy().getDiscount())));
        return result;
    }
}
