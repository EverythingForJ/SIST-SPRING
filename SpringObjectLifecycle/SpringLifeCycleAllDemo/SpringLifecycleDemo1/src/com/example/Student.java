package com.example;

import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class Student {
	@NonNull private String name;
	private @NonNull int age;
	@NonNull private List<String> hobbys;
	private @Setter double height;
	@Setter private double weight;
}
