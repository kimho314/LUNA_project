package com.newlecture.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.newlecture.di.entity.NewlecExam;

@Configuration
@ComponentScan("com.newlecture.di.ui")
public class NewlecAppConfig {
	
	@Bean
	public NewlecExam exam() {
		return new NewlecExam(1, 1, 1, 1);
	}
}
