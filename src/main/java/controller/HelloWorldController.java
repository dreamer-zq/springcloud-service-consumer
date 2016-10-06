package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.RestRemoteService;

@RestController
@RequestMapping(value="/api-a")
public class HelloWorldController {

	@Autowired
	RestRemoteService service;
	
	
	@RequestMapping(value="/sayHello",method = RequestMethod.GET)
	public String sayHi() {
		return service.sayHello();
	}
}
