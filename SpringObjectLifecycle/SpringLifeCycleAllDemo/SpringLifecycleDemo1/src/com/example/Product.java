package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.ToString;

@ToString
@Component
public class Product {
	@Value("Notebook")
	private String name;
	
	@Value("2500000")
	private int price;
	
	@Value("Samsung")
	private String maker;
	
	@Value("Silver")
	private String color;
}
