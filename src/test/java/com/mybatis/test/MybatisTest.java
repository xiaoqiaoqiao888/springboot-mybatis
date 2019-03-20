package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * sqlSession和connection非线程安全的，sqlsession代表与数据库的一次会话，用完必须关闭。每次使用都应该获取新的对象。。
 * 
 * @author qiaodongjie
 * @date 2019年3月15日 上午10:06:01
 *
 */
public class MybatisTest {
	/**
	 * select
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		String resource = "com/mybatis/test/mybatis-config.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);

		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Employee employee = (Employee) openSession.selectOne("com.mybatis.test.EmployeeMapper.getInfoById", 2);
			System.out.println(employee);

		} finally {
			// 必须关闭
			openSession.close();
		}

	}

	/**
	 * select getInfoByIdAndLastName
	 * 
	 * @throws IOException
	 */
	@Test
	public void testGetInfoByIdAndLastName() throws IOException {
		String resource = "com/mybatis/test/mybatis-config.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);

		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = employeeMapper.getInfoByIdAndLastName(1, "zhangsan");
			System.out.println(employee);

		} finally {
			// 必须关闭
			openSession.close();
		}

	}

	/**
	 * select
	 * 
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		String resource = "com/mybatis/test/mybatis-config.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);

		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = employeeMapper.getInfoById(1);
			System.out.println(employee);
			System.out.println(employeeMapper.getClass());

		} finally {
			// 必须关闭
			openSession.close();
		}

	}

	/**
	 * insert 增删改openSession.commit();这个一定要写
	 * 
	 * @throws IOException
	 */
	@Test
	public void test3() throws IOException {
		String resource = "com/mybatis/test/mybatis-config.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);

		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);

			Employee employee = new Employee();
			// employee.setEmail("123@qq.com");
			// employee.setGender(1);
			// employee.setLastName("Jack");
			// employeeMapper.addEmployee(employee);
			employee.setEmail("rose@qq.com");
			employee.setGender(0);
			employee.setLastName("Rose");
			employeeMapper.addEmployee1(employee);
			openSession.commit();// 一定要commit,不然数据不在数据库
			System.out.println(employee.getId());
			System.out.println(employeeMapper.getClass());

		} finally {
			// 必须关闭
			openSession.close();
		}

	}

	/**
	 * update
	 * 
	 * @throws IOException
	 */
	@Test
	public void test4() throws IOException {
		String resource = "com/mybatis/test/mybatis-config.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);

		SqlSession openSession = sqlSessionFactory.openSession();
		// sqlSessionFactory.openSession(true);
		try {
			EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);

			Employee employee = new Employee();
			// employee.setEmail("xiaoming@qq.com");
			// employee.setGender(1);
			// employee.setLastName("xiaoming");
			// employee.setId(1);
			// employeeMapper.updateEmployee(employee);

			employee.setEmail("lisi@qq.com");
			employee.setGender(1);
			employee.setLastName("lisi");
			employee.setId(10);
			employeeMapper.updateEmployee1(employee);
			openSession.commit();// 一定要commit,不然数据不在数据库
			System.out.println(employee.getId());
			System.out.println(employeeMapper.getClass());

		} finally {
			// 必须关闭
			openSession.close();
		}

	}

	/**
	 * delete
	 * 
	 * @throws IOException
	 */
	@Test
	public void test5() throws IOException {
		String resource = "com/mybatis/test/mybatis-config.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);

		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);

			employeeMapper.delEmployee(9);
			openSession.commit();// 一定要commit,不然数据不在数据库
			System.out.println(employeeMapper.getClass());

		} finally {
			// 必须关闭
			openSession.close();
		}

	}
}
