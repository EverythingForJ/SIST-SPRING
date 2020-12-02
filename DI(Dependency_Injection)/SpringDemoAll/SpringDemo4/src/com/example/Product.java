package com.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@ToString
public class Product {
	private @NonNull String pName;
	private @NonNull int pPrice;
	private String maker;
	private String color;
}
