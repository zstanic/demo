package com.skf.demo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.convert.DefaultRedisTypeMapper;
import org.springframework.data.redis.core.convert.MappingRedisConverter;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.core.convert.RedisTypeMapper;
import org.springframework.data.redis.core.convert.ReferenceResolver;
import org.springframework.data.redis.core.mapping.RedisMappingContext;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.skf.demo.component.ByteArrayToTimestamp;

@Configuration
@EnableRedisRepositories
public class Config {

	 @Bean
	  public LettuceConnectionFactory redisConnectionFactory() {
	    return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
	  }
	
	 @Bean
	 public RedisTemplate<String, String> redisTemplate(){
		 RedisTemplate<String, String> redTmp = new RedisTemplate<String, String>();
		 redTmp.setConnectionFactory(redisConnectionFactory());
		 
		 return redTmp;
	 }
	 
		@Bean
		public MappingRedisConverter redisConverter(RedisMappingContext mappingContext,
				RedisCustomConversions customConversions, ReferenceResolver referenceResolver) {

			MappingRedisConverter mappingRedisConverter = new MappingRedisConverter(mappingContext, null,
					referenceResolver, customTypeMapper());
			mappingRedisConverter.setCustomConversions(redisCustomConversions());
			return mappingRedisConverter;
		}

		@Bean
		public RedisTypeMapper customTypeMapper() {
			return new CustomRedisTypeMapper();
		}

		public RedisCustomConversions redisCustomConversions() {
			return new RedisCustomConversions(Arrays.asList(new ByteArrayToTimestamp()));
		}

		class CustomRedisTypeMapper extends DefaultRedisTypeMapper {

		}
}
