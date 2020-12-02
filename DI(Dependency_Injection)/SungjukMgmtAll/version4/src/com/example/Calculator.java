package com.example;

import lombok.Setter;

//@AllArgsConstructor
@Setter
public class Calculator {
	private StudentVO student;
	
	public void calcTot() {
		int tot = this.student.getKor()+this.student.getEng()+this.student.getMat();
		this.student.setTot(tot);
	}
	
	public void calcAvg() {
		double avg = this.student.getTot()/3.;
		this.student.setAvg(avg);
	}
	
	public void calcGrade() {
		char grade = (this.student.getAvg()>=90)?'A':
						(this.student.getAvg()>=80)?'B':
							(this.student.getAvg()>=70)?'C':
								(this.student.getAvg()>=60)?'D':'F';
		this.student.setGrade(grade);
	}
	
}