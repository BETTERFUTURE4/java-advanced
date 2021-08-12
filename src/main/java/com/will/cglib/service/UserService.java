package com.will.cglib.service;

/*
 * - Dynamic Proxy의 한계
 * 별도로 인터페이스가 구현되지 않은 객체.
 * Dynamic Proxy를 이용할 수 없음.
 * 이때 Spring AOP는 Cglib을 이용한다.
 *
 * - Cglib 의 한계 (3.x부터는 개선되었을수도)
 * 제약사항: 참고로 Cglib은 상속이 불가능하면 사용할 수 없음. (final class or private constructor ...)
 * Hibernate도 Cglib을 이용해서 프록시 객체를 생성한다, 그래서 protected 이상의 기본 생성자가 있어야하는 것이며 final class로 선언하면 안되는 이유이기도 함.
 *
 * - Spring Boot's Spring AOP
 * 근데 스프링 부트를 사용하면 인터페이스가 있더라도 Cglib으로 프록시 객체를 생성한다.
 * 이유는 간단하게 Cglib 2.x 버전에서는 여러 한계가 존재했었음 (Enhancer 의존성 추가, default 생성자, 타깃의 생성자를 두번 호출하는 등)
 * 하지만 Cglib 3.x로 넘어오면서 이러한 문제가 개선되어서 Spring boot를 사용하면 Cglib 방식으로 프록시를 생성하고 있음. (특정 버전 이상부터)
 */
public class UserService {

	public void signUp(String email) {
		System.out.printf("(%s) 회원가입 완료\n", email);
	}

	public void login(String email) {
		System.out.printf("(%s) 로그인 완료\n", email);
	}

}
