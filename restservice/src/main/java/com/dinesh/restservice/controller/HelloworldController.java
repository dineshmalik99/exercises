package com.dinesh.restservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.restservice.bean.HelloworldBean;

@RestController
@RequestMapping(path="/hello")
public class HelloworldController {
	
	@RequestMapping(method=RequestMethod.GET, path="/there")
	public String hello(){
		return "Hello-Dinesh";
	}
	
	@GetMapping(path="/gethellobean")
	public HelloworldBean getHelloworldBean(){
		return new HelloworldBean("This is my hello bean");
	}
	
}
