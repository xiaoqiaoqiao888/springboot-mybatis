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

	/**
	 * 增加Employee的方法
	 * 
	 * @param employee
	 * @return
	 */
	public int addEmployee(Employee employee);

	/**
	 * 根据id更新Employee
	 * 
	 * @param id
	 * @return
	 */
	public int updateEmployee(Integer id);

	/**
	 * 根据id删除Employee
	 * 
	 * @param id
	 * @return
	 */
	public int delEmployee(Integer id);
}
