package com.mybatis.test;

import org.apache.ibatis.annotations.Mapper;

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
