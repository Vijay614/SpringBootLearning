package com.vijay.demo.services;

import org.springframework.stereotype.Service;

@Service
public class staticAuth implements LoginServices{
	public Boolean authUser(String username,String password) {
		if(username.equals("vijay") && password.equals("12345"))
			return true;
		else
			return false;
	}
}
