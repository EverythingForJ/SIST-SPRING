package com.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
//@AllArgsConstructor // 모든 property를 파라미터로 갖는 생성자
//@RequiredArgsConstructor // 일부 property 를 파라미터로 갖는 생성자
//@NoArgsConstructor // 기본 생성자
//@ToString
public class StudentVO {

	private String hakbun;
	private String name;
//	private @NonNull int kor, eng, mat;
	private int kor, eng, mat;
	private int tot;
	private double avg;
	private char grade;
	
}
