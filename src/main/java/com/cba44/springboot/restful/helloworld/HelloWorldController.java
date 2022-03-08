package com.cba44.springboot.restful.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource bundleMessageSource;

	@GetMapping(path="/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}

	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World " + name);
	}

	@GetMapping(path="/hello-world-int")
	public String HelloWorldInternationalaized() {
		return bundleMessageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
