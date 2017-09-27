package com.my.study;



import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootApplication

public class DataRedisExample2Application {
	
	@Value("${spring.redis.host}")
	private String Hostname;
	@Value("${spring.redis.port}")
	private int port;
	
	@Bean
	JedisConnectionFactory getJedisconnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		System.out.println("HostName---"+Hostname+"Port address----->"+port);
		factory.setHostName(Hostname);
		factory.setPort(port);
		return factory;
	}

	@Bean
	RedisTemplate<String, User> getRedisTemplate() {
		RedisTemplate<String, User> template = new RedisTemplate<String, User>();
		template.setConnectionFactory(getJedisconnectionFactory());
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(DataRedisExample2Application.class, args);
	}
}
