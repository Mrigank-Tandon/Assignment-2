package com.quinbay.march22.dependencyinjection.config;

import com.quinbay.march22.dependencyinjection.dto.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class ApplicationConfig {

    @Bean
    JedisConnectionFactory jedisConnectionException(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("localhost");
        jedisConnectionFactory.setPort(6379);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String,Student> redisTemplate(){
        RedisTemplate<String,Student> template = new RedisTemplate<String, Student>();
        template.setConnectionFactory(jedisConnectionException());
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }
}




