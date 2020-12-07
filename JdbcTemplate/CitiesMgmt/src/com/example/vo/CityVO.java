package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CityVO {
	private int id;
	private String name;
	private String countryCode;
	private String district;
	private int population;
}
