package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

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
			openSession.close();
		}

	}
}
