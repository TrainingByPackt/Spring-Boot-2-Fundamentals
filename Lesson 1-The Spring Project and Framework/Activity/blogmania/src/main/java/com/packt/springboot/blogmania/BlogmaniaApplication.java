package com.packt.springboot.blogmania;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BlogmaniaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BlogmaniaApplication.class, args);
		List<BeanData> beans = new ArrayList<>();
		for (String s : context.getBeanDefinitionNames()) {
			System.out.println(s);
			beans.add(new BeanData(s, context.getBean(s).getClass().getCanonicalName()));
		}
//Alternative implementation using streams
//        List<BeanData> beans = Arrays.stream(context.getBeanDefinitionNames())
//                .sorted()
//                .peek(System.out::println)
//				  .map(s->new BeanData(s, context.getBean(s).getClass().getCanonicalName()))
//				  .collect( Collectors.toList());

		System.out.println();
		System.out.println("### BeanData ###");
		System.out.println();
		for (BeanData bean : beans) {
			System.out.println(bean.getBean()+": "+bean.getBeanClass());
			//You can also try the toString implementation that @Data provides:
			//System.out.println(bean);
		}
//Alternative implementation using streams
//		beans.stream()
//				.map(bean -> bean.getBean()+": "+bean.getBeanClass())
//				.forEach(System.out::println);
	}
}
