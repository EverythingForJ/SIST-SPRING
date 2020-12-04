package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "com.example")
public class ApplicationConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		configurer.setLocations(
				new ClassPathResource("admin.properties"),
				new ClassPathResource("sub.admin.properties")
				);
		return configurer;
	}
	
//	Spring Bean Configuration File(beans.xml)에서 다음과 같다.
//	<context:property-placeholder
//	location="classpath:admin.properties, classpath:sub.admin.properties" />

}
