package com.will.dynamicproxy;

import com.will.dynamicproxy.service.DefaultUserService;
import com.will.dynamicproxy.service.ProxyUserService;
import com.will.dynamicproxy.service.UserService;

public class ProxyApplication {

	public static void main(String[] args) {
		UserService userService = new ProxyUserService(new DefaultUserService());
		userService.signUp("will.seungho@gmail.com");
	}

}
