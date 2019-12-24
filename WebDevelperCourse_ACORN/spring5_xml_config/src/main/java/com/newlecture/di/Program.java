package com.newlecture.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.di.entity.Exam;
import com.newlecture.di.entity.NewlecExam;
import com.newlecture.di.ui.ExamConsole;
import com.newlecture.di.ui.GridExamConsole;
import com.newlecture.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		//Exam exam = new NewlecExam(10,10,10,10);	
		
		//ExamConsole console = new GridExamConsole();// DI 있다? 없다?
		//console.setExam(exam);
		//String path = "com/newlecture/di/config.xml";
		//String path = "d:\\example\\di\\config.xml";
		//ApplicationContext context = new ClassPathXmlApplicationContext(path);
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(NewlecAppConfig.class);
		
		ExamConsole console = (ExamConsole) context.getBean("console");//
		//ExamConsole console = context.getBean(ExamConsole.class);//
		console.print();
		
	}

}
