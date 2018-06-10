package com.packt.springboot.blogmania;

import com.packt.springboot.blogmania.blogentries.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BlogmaniaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BlogmaniaApplication.class, args);
/* not needed anymore
		for (String s : context.getBeanDefinitionNames()) {
			System.out.println(s);
		}
		 */
//Alternatively for sorted output
//        Arrays.stream(context.getBeanDefinitionNames())
//                .sorted()
//                .forEach(System.out::println);
    }

    @Autowired
    public void greetingService(GreetingService service) {
        System.out.println(service.greet("Patrick"));
    }

    //You could do this in the other classes or the application class as well
    @Component
    public static class AdvancedSolution {
        @Autowired
        GreetingService greetingService;

        @PostConstruct
        public void done() {
            System.out.println(greetingService.greet("The team"));
        }
    }
}
