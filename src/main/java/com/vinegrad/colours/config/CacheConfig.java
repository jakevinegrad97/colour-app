package com.vinegrad.colours.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

import lombok.Setter;

@Configuration
@Setter
public class CacheConfig {
	
	@Value("${cache.ttl}")
	private long ttl;
	@Value("${cache.unit}")
	private TimeUnit unit;
	
	@Bean
	public CacheManager cacheManager() {
		var caffeine = Caffeine.newBuilder().expireAfterWrite(ttl, unit);
		var cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(caffeine);
		return cacheManager;
	}

}
