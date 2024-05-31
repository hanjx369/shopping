package com.hanjx369.demo.controller;

import com.hanjx369.demo.domain.Result;
import com.hanjx369.demo.service.ShoppingService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 购物控制器
 *
 * @author 寒江雪
 * @createDate 2024-05-29 23:25
 */
@Slf4j
@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Resource(name = "shoppingService1")
    private ShoppingService shoppingService1;

    @Resource(name = "shoppingService2")
    private ShoppingService shoppingService2;

    @Resource(name = "shoppingService3")
    private ShoppingService shoppingService3;

    /**
     * 购买商品
     *
     * @param userId        用户ID
     * @param merchandiseId 商品ID
     * @return 购买结果
     */
    @GetMapping("/buy")
    public Result<Map<String, Object>> buy(Long userId, Long merchandiseId) {
        log.info("user id: {}, merchandise id: {}", userId, merchandiseId);
        if (userId == null || merchandiseId == null) {
            return Result.fail("参数错误");
        }
        return Result.success(shoppingService3.buy(userId, merchandiseId), "购买成功");
    }
}
