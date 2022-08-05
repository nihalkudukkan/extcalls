package com.blade.demo.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blade.demo.bean.Sex;
import com.blade.demo.bean.User;
import com.blade.demo.bean.Users;
import com.blade.demo.bean.request.UserRequest;
import com.blade.demo.config.DemoConfig;
import com.blade.demo.services.IDemoDataService;

@Service
public class DemoDataService implements IDemoDataService {
	@Autowired
	DemoConfig config;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User RestTempl() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "1234");
		
		UserRequest name = new UserRequest("nihal");
		
		HttpEntity<UserRequest> entity = new HttpEntity<>(name, headers);
		ResponseEntity<User> usersEntity = restTemplate.exchange(config.getUserUrl(), HttpMethod.POST, entity, User.class);
		return usersEntity.getBody();
	}

	@Override
	public User[] allUsers() {
		ResponseEntity<User[]> usersEntity = restTemplate.exchange(config.getAllusersUrl(), HttpMethod.GET, null, User[].class);
		return usersEntity.getBody();
	}
}
