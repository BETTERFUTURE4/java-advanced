package com.will.reflect.di;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 리플랙션을 이용하면 컴파일 시점에 존재하지 않는 클래스들을 이용할 수 있음.
 * -
 * 그래서 프레임워크 등에서 많이 사용됨.
 * 예를 들어서 Spring MVC의 DispatcherServlet에서 요청에 대한 HandlerMapping, Handler를 실행하는 HandlerAdapter
 * 혹은 IoC Container에서 빈을 주입해주는 등 너무 많은 곳에서 사용되고 있다.
 * -
 * 단 단점이 있다.
 * 리플랙션을 이용한다는 것은 컴파일 타입 검사를 이용할 수 없다는 것이다.
 * 또한 리플랙션의 메소드를 사용하는 것은 그냥 메소드를 사용하는 것보다 훨씬 성능이 느림.
 * 하지만 프레임워크 등 일부적으로 사용이 필요한 곳에서 널리 사용되고 있음.
 */
public class ContainerService {

	public <T> T getObject(Class<T> classType) {
		T instance = newInstance(classType);

		for (Field field : classType.getDeclaredFields()) {
			if (field.getAnnotation(Inject.class) != null) {
				Object fieldInstance = newInstance(field.getType());
				field.setAccessible(true);
				try {
					field.set(instance, fieldInstance);
				} catch (IllegalAccessException e) {
					throw new IllegalArgumentException("예외가 발생하였습니다", e);
				}
			}
		}
		return instance;
	}

	private <T> T newInstance(Class<T> classType) {
		try {
			return classType.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new IllegalArgumentException("예외가 발생하였습니다", e);
		}
	}

}
