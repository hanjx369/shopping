package com.hanjx369.demo.cache.handler;

import com.hanjx369.demo.cache.context.CacheInitializationAware;
import com.hanjx369.demo.utils.ApplicationContextUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

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
    private ApplicationContextUtil applicationContextUtil;

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext context = applicationContextUtil.getContext();
        Map<String, CacheInitializationAware> beans = context.getBeansOfType(CacheInitializationAware.class);
        for (Map.Entry<String, CacheInitializationAware> cacheInitializationAwareEntry : beans.entrySet()) {
            CacheInitializationAware bean = context.getBean(cacheInitializationAwareEntry.getValue().getClass());
            bean.init();
        }
    }

}
