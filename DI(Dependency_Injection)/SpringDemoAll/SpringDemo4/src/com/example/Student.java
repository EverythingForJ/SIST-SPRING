package com.example;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Student {
	private @NonNull String name;
	private @NonNull int age;
	private @NonNull ArrayList<String> hobbys;
	private double height;
	private double weight;
}
