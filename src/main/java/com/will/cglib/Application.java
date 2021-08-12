package com.will.cglib;

import com.will.cglib.service.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {

	public static void main(String[] args) {
		UserService userService = (UserService) Enhancer.create(UserService.class, new MethodInterceptor() {

			private final UserService userService = new UserService();

			@Override
			public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws InvocationTargetException, IllegalAccessException {
				if (method.getName().equals("signUp")) {
					System.out.println("회원가입 요청이 들어왔습니다.");
					Object invoke = method.invoke(userService, args);
					System.out.println("회원가입 요청이 종료됩니다.");
					return invoke;
				}
				return method.invoke(userService, args);
			}
		});
		userService.signUp("will.seungho@gmail.com");
		userService.login("will.seungho@gmail.com");
	}

}
