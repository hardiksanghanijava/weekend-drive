package com.weekend.drive.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableDiscoveryClient
public class InterviewMiniProjectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(InterviewMiniProjectApplication.class, args);
	}
	
	@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("status-cache");
    }
	
	
}
