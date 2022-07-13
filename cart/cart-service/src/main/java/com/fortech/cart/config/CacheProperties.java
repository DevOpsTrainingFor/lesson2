package com.fortech.cart.config;

import java.time.Duration;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cache")
public class CacheProperties {

  private Map<String, Duration> ttl;

  public CacheProperties(Map<String, Duration> ttl) {
    this.ttl = ttl;
  }

  public Map<String, Duration> getTtl() {
    return ttl;
  }

  public void setTtl(Map<String, Duration> ttl) {
    this.ttl = ttl;
  }
}
