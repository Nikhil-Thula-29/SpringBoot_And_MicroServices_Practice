package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj16I18nApplication {
	
	
	//resolvers are to activate some special features like I18n and multipartfile for file uploading 
	@Bean(name="localeResolver")	//fixed id
	public SessionLocaleResolver createSLResolver() {
		SessionLocaleResolver resolver=new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en","US"));
		return resolver;
	}
	
	@Bean(name="lci")
	public LocaleChangeInterceptor createLOC() {
		LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
		interceptor.setParamName("lang");	//in link we pass this ?lang=
		return interceptor;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj16I18nApplication.class, args);
	}

}
