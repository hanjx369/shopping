package com.hanjx369.demo.strategy;

import com.hanjx369.demo.cache.MerchandiseCache;
import com.hanjx369.demo.cache.UserCache;
import com.hanjx369.demo.entity.Merchandise;
import com.hanjx369.demo.entity.User;
import com.hanjx369.demo.enums.DiscountEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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
public class VIPStrategy implements ShoppingStrategy {

    @Resource
    private UserCache userCache;

    @Resource
    private MerchandiseCache merchandiseCache;

    @Override
    public DiscountEnum getStrategy() {
        return DiscountEnum.VIP;
    }

    @Override
    public Map<String, Object> buy(User user, Merchandise merchandise) {
        Map<String, Object> result = new HashMap<>();
        result.put("用户姓名", user.getName());
        result.put("商品名称", merchandise.getName());
        result.put("商品原价", merchandise.getPrice());
        result.put("折后价格", merchandise.getPrice().multiply(getStrategy().getDiscount()));
        return result;
    }
}
