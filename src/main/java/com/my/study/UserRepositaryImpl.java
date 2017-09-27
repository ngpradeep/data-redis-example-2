package com.my.study;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import com.my.study.model.User;

@Repository
public class UserRepositaryImpl implements UserRepositary{

	
	private RedisTemplate<String,User> redisTemplate;
	
	private HashOperations hashOperations;
	
	@Autowired
	public UserRepositaryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		hashOperations.put("USER", user.getId(), user);
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		hashOperations.put("USER", user.getId(), user);
	}

	@Override
	public Map<String,User> findall() {
		// TODO Auto-generated method stub
		return hashOperations.entries("USER");
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		hashOperations.delete("USER", id);
		
	}

	@Override
	public User findByUser(String id) {
		// TODO Auto-generated method stub
		return (User) hashOperations.get("USER", id);
	}

}
