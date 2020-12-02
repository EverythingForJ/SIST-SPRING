package com.example;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//@Setter
@Getter
//@AllArgsConstructor // 모든 property를 파라미터로 갖는 생성자
@RequiredArgsConstructor // 일부 property 를 파라미터로 갖는 생성자
//@NoArgsConstructor // 기본 생성자
//@ToString
public class StudentVO {

	private @NonNull String hakbun;
	private @NonNull String name;
	private @NonNull int kor, eng, mat;
//	private int kor, eng, mat;
	private @Setter int tot;
	private @Setter double avg;
	private @Setter char grade;
	
}
