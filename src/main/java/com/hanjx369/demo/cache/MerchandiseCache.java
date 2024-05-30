package com.hanjx369.demo.cache;

import com.alibaba.fastjson2.JSON;
import com.hanjx369.demo.cache.context.AbstractCache;
import com.hanjx369.demo.entity.Merchandise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 商品缓存
 *
 * @author 寒江雪
 * @createDate 2024-05-29 23:31
 */
@Slf4j
@Component
public class MerchandiseCache extends AbstractCache<Long, Merchandise> {

    private final Map<Long, Merchandise> merchandiseMap = new HashMap<>();

    @Override
    public void init() {
        this.merchandiseMap.put(1L, Merchandise.builder().id(1L).name("小米14").price(BigDecimal.valueOf(3999.00)).build());
        this.merchandiseMap.put(2L, Merchandise.builder().id(2L).name("小米路由器").price(BigDecimal.valueOf(399.00)).build());
        this.merchandiseMap.put(3L, Merchandise.builder().id(3L).name("小米扫地机器人").price(BigDecimal.valueOf(2299.00)).build());
        this.merchandiseMap.put(4L, Merchandise.builder().id(4L).name("小米电视S75英寸4K").price(BigDecimal.valueOf(3899.00)).build());
        this.merchandiseMap.put(5L, Merchandise.builder().id(5L).name("小米SoundPro").price(BigDecimal.valueOf(899)).build());
        log.info("merchandise cache init success: {}", JSON.toJSONString(this.merchandiseMap));
    }

    @Override
    public Merchandise get(Long key) {
        return this.merchandiseMap.get(key);
    }

    @Override
    public void clear() {
        this.merchandiseMap.clear();
    }
}
