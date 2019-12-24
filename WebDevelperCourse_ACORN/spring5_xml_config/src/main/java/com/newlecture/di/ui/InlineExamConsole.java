package com.newlecture.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newlecture.di.entity.Exam;

@Component("console")
public class InlineExamConsole implements ExamConsole {
	
	//@Qualifier("exam1")
	@Autowired
	private Exam exam;		
	
	public InlineExamConsole() {
		System.out.println("constructor");	
	}	
		
	public InlineExamConsole(Exam exam) {	
		System.out.println("overloaded constructor");
		this.exam = exam;
	}
	
	@Override
	public void print() {
		//if(exam == null)
		//	System.out.printf("total is %d, avg is %f\n", 0, 0.0);
		//else
			System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
	}
	
	
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}

}
