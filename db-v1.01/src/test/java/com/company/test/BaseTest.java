package com.company.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {

	protected ClassPathXmlApplicationContext context;

	@Before
	public void doBefore() {
		context = new ClassPathXmlApplicationContext("spring.xml");
	}

	@Test
	public void dsTest() throws SQLException {
		DataSource ds = context.getBean("ds", DataSource.class);
		System.out.println(ds.getConnection());
	}

	@After
	public void doAfter() {
		context.close();
	}
}
