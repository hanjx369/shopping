package com.hanjx369.demo.cache.context;

/**
 * 缓存热启动抽象类
 *
 * @author 寒江雪
 * @createDate 2024-05-29 22:33
 */
public abstract class AbstractCache<K, V> implements CacheInitializationAware {

    /**
     * 获取
     *
     * @param key 键
     * @return 值
     */
    public abstract V get(K key);

    /**
     * 清空
     */
    public abstract void clear();

    /**
     * 重新加载
     */
    public void reload() {
        clear();
        init();
    }

}
