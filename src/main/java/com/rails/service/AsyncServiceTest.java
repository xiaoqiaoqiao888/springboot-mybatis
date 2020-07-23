package com.rails.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceTest {

	@Async
	public Future<String> helloTest() throws Exception {

		try {
			Thread.sleep(3000);
			throw new Exception();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new AsyncResult<String>("SUCCESS");

	}
}
