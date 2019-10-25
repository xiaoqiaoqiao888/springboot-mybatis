package com.rails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rails.entity.Employee;
import com.rails.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
@Api(value = "员工服务")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	/**
	 * employee基本信息查询
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("/baseInfo")
	@ApiOperation(value = "employee基本信息查询", notes = "employee基本信息查询", tags = { "employee-service" })
	public Employee getInfoById(@ApiParam(value = "id", required = true) @RequestParam Integer id) {

		return employeeService.getInfoById(id);

	}
}
