package com.my.study;
import java.util.Map;

import com.my.study.model.User;


public interface UserRepositary {
	public void saveUser(User user);
	public void updateUser(User user);
	public  Map<String,User> findall();
	public void deleteUser(String id);
	public User findByUser(String id);
}
