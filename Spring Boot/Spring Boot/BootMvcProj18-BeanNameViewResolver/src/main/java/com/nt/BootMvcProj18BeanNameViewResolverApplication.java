package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class BootMvcProj18BeanNameViewResolverApplication {

	@Bean
	public BeanNameViewResolver createResolver() {
		BeanNameViewResolver resolver=new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);	//importance for this view resolver
		return resolver;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj18BeanNameViewResolverApplication.class, args);
	}

}
