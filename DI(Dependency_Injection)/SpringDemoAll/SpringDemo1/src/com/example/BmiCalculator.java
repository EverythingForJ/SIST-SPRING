package com.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BmiCalculator {
	private double lowWeight;
	private double normal;
	private double overWeight;
	private double obesity;

	public void bmiCalcu(double weight, double height) {
		double h = height * 0.01;
		double result = weight / (h * h);
		System.out.println("BMI 지수 : " + (int) result);
		if (result > obesity)
			System.out.println("비만입니다.");
		else if (result > overWeight)
			System.out.println("과체중입니다.");
		else if (result > normal)
			System.out.println("정상입니다.");
		else
			System.out.println("저체중입니다.");
	}
}
