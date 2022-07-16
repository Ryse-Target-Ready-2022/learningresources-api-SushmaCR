package com.tgt.rysetii.learningresourcesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;


@SpringBootApplication
public class LearningresourcesapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningresourcesapiApplication.class, args);
		LearningResourceService obj = new LearningResourceService();
		System.out.println(obj.getLearningResource());
	}

}
