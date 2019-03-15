package com.mybatis.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @Alias("emp")//可以用注解起别名
public class Employee {
	private Integer id;
	private String lastName;
	private Integer gender;
	private String email;

}
