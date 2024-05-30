package com.hanjx369.demo.cache.handler;

import com.hanjx369.demo.cache.context.CacheInitializationAware;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 热启动
 *
 * @author 寒江雪
 * @createDate 2024-05-29 22:49
 */
@Slf4j
@Component
public class CacheInitializer {

    @Resource
    private List<CacheInitializationAware> cacheInitializationAwareList;

    /**
     * 加载缓存
     */
    @PostConstruct
    public void load() {
        cacheInitializationAwareList.forEach(CacheInitializationAware::init);
    }

}
