package com.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestClient {
	public static void main(String[] args) {
		BeanFactory bean = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		Animal tomdog = (Animal) bean.getBean("tomdog");
		tomdog.walwal();
	}
}
