package com.rails.service;

import com.rails.entity.Employee;

public interface EmployeeService {

	/**
	 * 根据id查询Employee信息
	 * 
	 * @param id
	 * @return
	 */
	public Employee getInfoById(Integer id);
}
