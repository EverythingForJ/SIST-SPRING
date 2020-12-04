package com.example;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Component("hello1")
public class Hello1 {
	@Value("${myname}")
	private String name;
	@Resource(name = "${myprinter}")
	private Printer printer;
	
	@Value("${value1},${value2},${value3},${value4}")
	@Getter
	private List<String> hobbies;

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}
}
