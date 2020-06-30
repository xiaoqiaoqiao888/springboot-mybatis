package com.rails.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

	@Autowired
	private AsyncService asyncService;

	@GetMapping("/hello")
	public String hello(@RequestParam String str) {

		asyncService.hello();

		return "SUCCESS";
	}
}
