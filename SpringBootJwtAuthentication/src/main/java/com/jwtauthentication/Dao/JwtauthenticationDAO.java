package com.jwtauthentication.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jwtauthentication.model.User;
import com.jwtauthentication.repository.UserRepository;

@Service
public class JwtauthenticationDAO {
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
    public User save(User user) {
		return userRepository.save(user);
	}
}
