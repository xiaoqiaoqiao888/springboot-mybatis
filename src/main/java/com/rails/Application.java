package com.rails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.rails.async.Test;

@SpringBootApplication
//@EnableAsync
public class Application {
	public static void main(String[] args) {
//		System.out.println("开始执行......");
//		new Test().notify("testFile");
//		System.out.println("结束执行......");
		SpringApplication.run(Application.class, args);
	}
}
