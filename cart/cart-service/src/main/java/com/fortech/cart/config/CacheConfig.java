package com.fortech.cart.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
@EnableCaching
/*
  Keypoint: Caching config in common library
 */
public class CacheConfig extends CachingConfigurerSupport {

  private final CacheProperties cacheProperties;

  public CacheConfig(CacheProperties cacheProperties) {
    this.cacheProperties = cacheProperties;
  }

  @Bean
  public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(
      RedisCacheConfiguration defaultConfig) {
    var caches = Optional.ofNullable(cacheProperties.getTtl())
        .orElse(new HashMap<>()).entrySet().stream()
        .collect(Collectors.toMap(Entry::getKey, p -> defaultConfig.entryTtl(p.getValue())));

    return (builder) -> builder
        .withInitialCacheConfigurations(caches);
  }

  @Bean
  public RedisCacheConfiguration cacheConfiguration() {
    return RedisCacheConfiguration.defaultCacheConfig()
        .entryTtl(Duration.ofMinutes(5))
        .disableCachingNullValues()
        .serializeValuesWith(
            SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
  }

}
