package com.hanjx369.demo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.hanjx369.demo.cache.MerchandiseCache;
import com.hanjx369.demo.cache.UserCache;
import com.hanjx369.demo.entity.Merchandise;
import com.hanjx369.demo.entity.User;
import com.hanjx369.demo.service.ShoppingService;
import com.hanjx369.demo.strategy.ShoppingStrategy;
import com.hanjx369.demo.strategy.factory.ShoppingFactory;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 寒江雪
 * @createDate 2024-05-29 23:26
 */
@Slf4j
@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Resource
    private ShoppingFactory shoppingFactory;

    @Resource
    private UserCache userCache;

    @Resource
    private MerchandiseCache merchandiseCache;

    /**
     * 购买
     *
     * @param userId        用户ID
     * @param merchandiseId 商品ID
     * @return 购买结果
     */
    @Override
    public Map<String, Object> buy(Long userId, Long merchandiseId) {
        User user = userCache.get(userId);
        Merchandise merchandise = merchandiseCache.get(merchandiseId);
        log.info("current user: {}", JSON.toJSONString(user));
        log.info("current merchandise: {}", JSON.toJSONString(merchandise));
        ShoppingStrategy strategy = shoppingFactory.getStrategy(user.getType());
        return strategy.buy(user, merchandise);
    }
}
