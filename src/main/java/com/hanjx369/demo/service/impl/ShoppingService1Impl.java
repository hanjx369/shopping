package com.hanjx369.demo.service.impl;

import com.alibaba.fastjson2.JSON;
import com.hanjx369.demo.cache.MerchandiseCache;
import com.hanjx369.demo.cache.UserCache;
import com.hanjx369.demo.entity.Merchandise;
import com.hanjx369.demo.entity.User;
import com.hanjx369.demo.enums.DiscountEnum;
import com.hanjx369.demo.service.ShoppingService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Map;

/**
 * 普通实现
 *
 * @author 寒江雪
 * @createDate 2024-05-31 22:01
 */
@Slf4j
@Service("shoppingService1")
public class ShoppingService1Impl implements ShoppingService {

    @Resource
    private UserCache userCache;

    @Resource
    private MerchandiseCache merchandiseCache;

    /**
     * 购买商品
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
        DecimalFormat df = new DecimalFormat("0.00");
        DiscountEnum discountEnum = DiscountEnum.valueOf(user.getType());
        log.info("user type: {}, 享受折扣: {}", discountEnum.getType(), df.format(discountEnum.getDiscount()));
        // 普通用户
        if (user.getType() == 0) {
            return Map.of("用户姓名", user.getName(),
                    "商品名称", merchandise.getName(),
                    "商品价格", merchandise.getPrice(),
                    "折后价格", merchandise.getPrice().multiply(discountEnum.getDiscount()));

        } else
            // 普通VIP
            if (user.getType() == 1) {
                return Map.of("用户姓名", user.getName(),
                        "用户性别", user.getGender(),
                        "用户等级", discountEnum.getType(),
                        "商品名称", merchandise.getName(),
                        "商品价格", merchandise.getPrice(),
                        "应享折扣", discountEnum.getDiscount(),
                        "折后价格", merchandise.getPrice().multiply(discountEnum.getDiscount()));
            } else
                // 高级VIP
                if (user.getType() == 2) {
                    return Map.of(
                            "用户姓名", user.getName(),
                            "用户年龄", user.getAge(),
                            "用户等级", discountEnum.getType(),
                            "商品名称", merchandise.getName(),
                            "商品价格", merchandise.getPrice(),
                            "应享折扣", discountEnum.getDiscount(),
                            "折后价格", merchandise.getPrice().multiply(discountEnum.getDiscount()));
                } else
                    // 至尊VIP
                    if (user.getType() == 3) {
                        return Map.of("用户姓名", user.getName(),
                                "用户性别", user.getGender(),
                                "用户年龄", user.getAge(),
                                "用户等级", discountEnum.getType(),
                                "商品名称", merchandise.getName(),
                                "商品价格", merchandise.getPrice(),
                                "应享折扣", discountEnum.getDiscount(),
                                "折后价格", merchandise.getPrice().multiply(discountEnum.getDiscount()));
                    } else
                        // 超级VIP
                        if (user.getType() == 4) {
                            return Map.of("用户ID", user.getId(),
                                    "用户姓名", user.getName(),
                                    "用户性别", user.getGender(),
                                    "用户年龄", user.getAge(),
                                    "用户等级", discountEnum.getType(),
                                    "商品名称", merchandise.getName(),
                                    "商品价格", merchandise.getPrice(),
                                    "应享折扣", discountEnum.getDiscount(),
                                    "折后价格", merchandise.getPrice().multiply(discountEnum.getDiscount()));
                        }
        return Map.of();
    }

}
