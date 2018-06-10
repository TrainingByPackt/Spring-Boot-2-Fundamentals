package com.packt.springboot.blogmania;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogmaniaApplicationTests {

	@Autowired
	TestClass testClass;

	@Test
	public void contextLoads() {

	}

}
