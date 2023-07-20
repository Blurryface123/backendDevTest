package com.example.backendDevTest.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Caching config.
 */
@Configuration
@EnableCaching
public class CachingConfig {

    /**
     * Cache manager cache manager.
     *
     * @return the cache manager
     */
    @Bean
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager("similarProductsId","productDetails");
    }
}
