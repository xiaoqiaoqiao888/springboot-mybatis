package com.rails.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rails.entity.Employee;
import com.rails.mapper.EmployeeMapper;
import com.rails.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper EmployeeMapper;

	/**
	 * 根据id查询Employee信息
	 */
	@Override
	public Employee getInfoById(Integer id) {

		Employee employee = EmployeeMapper.getInfoById(id);
		return employee;
	}

}
