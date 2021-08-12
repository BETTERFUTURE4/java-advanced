package com.will.reflect;

import com.will.reflect.controller.SampleController;
import com.will.reflect.di.ContainerService;

public class Application {

	public static void main(String[] args) {
		ContainerService containerService = new ContainerService();
		SampleController controller = containerService.getObject(SampleController.class);
		controller.sayHello();
	}

}
