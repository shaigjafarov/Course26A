package az.code.course26a.config;

import java.time.Duration;
import java.util.List;

import az.code.course26a.entity.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
public class RedisConfig {
  @Value("${spring.data.redis.host}")
  private String redisHost;

  @Value("${spring.data.redis.port}")
  private int redisPort;


  @Bean
  public LettuceConnectionFactory redisConnectionFactory() {
    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);
    return new LettuceConnectionFactory(configuration);
  }
  
//  @Bean
//  public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//    return RedisCacheManager.create(connectionFactory);
//  }

  @Bean
  public RedisCacheManager cacheManager() {
    RedisCacheConfiguration cacheConfig = myDefaultCacheConfig(Duration.ofMinutes(1)).disableCachingNullValues();

    return RedisCacheManager.builder(redisConnectionFactory())
        .cacheDefaults(cacheConfig)
        .withCacheConfiguration("tutorials", myDefaultCacheConfig(Duration.ofMinutes(5)))
        .withCacheConfiguration("tutorial", myDefaultCacheConfig(Duration.ofMinutes(1)))
        .build();
  }

  @Bean
  public RedisTemplate<String, List<Employee>> redisTemplate() {
    RedisTemplate<String, List<Employee>> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory());
    redisTemplate.setKeySerializer(new GenericJackson2JsonRedisSerializer());
    redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    return redisTemplate;
  }

  private RedisCacheConfiguration myDefaultCacheConfig(Duration duration) {
    return RedisCacheConfiguration
        .defaultCacheConfig()
        .entryTtl(duration)
        .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
  }

}