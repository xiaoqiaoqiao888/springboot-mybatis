package com.rails.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rails.service.AsyncServiceTest;

@RestController
public class AsyncControllerTest {
	@Autowired
	private AsyncServiceTest asyncService;

	@GetMapping("helloTest")
	public String helloTest() throws Exception {
		Future<String> hello = asyncService.helloTest();
		return hello.get();
	}
}
