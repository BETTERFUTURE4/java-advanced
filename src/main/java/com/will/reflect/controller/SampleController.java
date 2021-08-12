package com.will.reflect.controller;

import com.will.reflect.di.Inject;
import com.will.reflect.service.SampleService;
import com.will.reflect.service.SampleTwoService;

public class SampleController {

	@Inject
	private SampleService sampleService;

	@Inject
	private SampleTwoService sampleTwoService;

	public void sayHello() {
		sampleService.sayHello();
		sampleTwoService.sayHello();
	}

}
