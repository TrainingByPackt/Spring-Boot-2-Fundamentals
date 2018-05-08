package com.packt.springboot.blogmania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BlogmaniaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BlogmaniaApplication.class, args);
		for (String s : context.getBeanDefinitionNames()) {
			System.out.println(s);
		}
//Alternatively for sorted output
//        Arrays.stream(context.getBeanDefinitionNames())
//                .sorted()
//                .forEach(System.out::println);
	}
}
