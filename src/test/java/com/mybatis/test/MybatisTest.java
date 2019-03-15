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

	@Test
	public void test3() throws IOException {
		String resource = "com/mybatis/test/mybatis-config.xml";
		InputStream stream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);

		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper employeeMapper = openSession.getMapper(EmployeeMapper.class);

			Employee employee = new Employee();
			employee.setEmail("123@qq.com");
			employee.setGender(1);
			employee.setLastName("Jack");
			employeeMapper.addEmployee(employee);
			System.out.println(employee.getId());
			System.out.println(employeeMapper.getClass());

		} finally {
			// 必须关闭
			openSession.close();
		}

	}
}
