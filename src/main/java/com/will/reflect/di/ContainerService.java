package com.will.reflect.di;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

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
