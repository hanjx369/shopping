package com.hanjx369.demo.cache.handler;

import com.hanjx369.demo.cache.context.CacheInitializationAware;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
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
public class CacheInitializer implements CommandLineRunner {

    @Resource
    private List<CacheInitializationAware> cacheInitializationAwareList;

    @Override
    public void run(String... args) throws Exception {
        for (CacheInitializationAware cacheInitializationAware : cacheInitializationAwareList) {
            cacheInitializationAware.init();
        }
    }

}
