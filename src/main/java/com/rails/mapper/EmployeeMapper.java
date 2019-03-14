package com.rails.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.rails.entity.Employee;

@Mapper
public interface EmployeeMapper {

	/**
	 * 根据id查询Employee信息
	 * 
	 * @param id
	 * @return
	 */
	public Employee getInfoById(Integer id);
}
