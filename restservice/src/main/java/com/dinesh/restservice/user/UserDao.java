package com.dinesh.restservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	private static List<User> users = new ArrayList<>();
	
	private static int countUser =0;
	static{
		users.add(new User(++countUser, "Dinesh", new Date()));
		users.add(new User(++countUser, "Deepak", new Date()));
		users.add(new User(++countUser, "Akash", new Date()));
		users.add(new User(++countUser, "Rahul", new Date()));
		
	}

	public User getUser(int id){
		return users.stream().filter(a->a.getId()==id).findAny().orElse(null);
	}
	
	public User getUserbyName(String name){
		return users.stream().filter(a->a.getName().equalsIgnoreCase(name)).findAny().orElse(null);
	}
	
	public List<User> getAllUser(){
		return users;
	}
	
	public User saveUser(User user){
		if(user.getId()==null){
			user.setId(++countUser);
		}
		users.add(user);
		return user;
	}
	
	public User deleteUser(int id){
		User user = users.stream().filter(a->a.getId()==id).findFirst().orElse(null);
		if(user!=null){
			users.remove(user);
		}
		return user;
	}
}
