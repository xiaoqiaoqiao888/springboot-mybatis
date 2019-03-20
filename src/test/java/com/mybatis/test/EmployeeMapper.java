package com.mybatis.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	 * 根据id,lastName查询Employee信息
	 * 
	 * @param id
	 * @param lastName
	 * @return
	 */
	public Employee getInfoByIdAndLastName(@Param(value = "id") Integer id, @Param(value = "lastName") String lastName);

	/**
	 * 增加Employee的方法
	 * 
	 * @param employee
	 * @return
	 */
	public int addEmployee(Employee employee);

	/**
	 * 增加Employee的方法 动态sql
	 * 
	 * @param employee
	 * @return
	 */
	public int addEmployee1(Employee employee);

	/**
	 * 根据id更新Employee
	 * 
	 * @param id
	 * @return
	 */
	public int updateEmployee(Employee employee);

	/**
	 * 根据id更新Employee 动态sql
	 * 
	 * @param id
	 * @return
	 */
	public int updateEmployee1(Employee employee);

	/**
	 * 根据id删除Employee
	 * 
	 * @param id
	 * @return
	 */
	public int delEmployee(Integer id);
}
