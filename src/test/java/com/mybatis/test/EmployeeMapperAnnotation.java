package com.mybatis.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapperAnnotation {

	/**
	 * 根据id查询Employee信息
	 * 
	 * @param id
	 * @return
	 */
	@Select(value = "select * from tbl_employee where id =#{id}")
	public Employee getInfoById(Integer id);
}
