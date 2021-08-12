package com.will.dynamicproxy.service;

/**
 * 타깃 객체에 부가적인 기능을 수헹하는 프록시 객체
 * 횡단간 중복을 제거할 수 있음. (트랜잭션 부가기능 or 로깅 부가 기능 등)
 * 타깃 객체에 부가 기능을 추가하면, 중복으로 인해 코드가 난잡해지고, 변경에 유연하게 대응할 수 없음. (SRP 위반)
 * -
 * 제약사항: Dynamic Proxy는 인터페이스가 있을때만 사용가능함.
 */
public class ProxyUserService implements UserService {

	private final UserService userService;

	public ProxyUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void signUp(String email) {
		System.out.printf("(%s) 회원가입 요청이 들어왔습니다\n", email);
		userService.signUp(email);
		System.out.printf("(%s) 회원가입 요청이 종료됩니다\n", email);
	}

}
