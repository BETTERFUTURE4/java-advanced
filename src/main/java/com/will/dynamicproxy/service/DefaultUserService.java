package com.will.dynamicproxy.service;

/**
 * 실제 로직을 수행하는 타깃 객체.
 */
public class DefaultUserService implements UserService {

	@Override
	public void signUp(String email) {
		System.out.printf("(%s) 회원가입 완료\n", email);
	}

}
