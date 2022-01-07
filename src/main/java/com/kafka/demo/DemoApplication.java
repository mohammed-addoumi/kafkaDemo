package com.kafka.demo;

import com.kafka.demo.producers.TeacherProducer;
import com.kafkademo.schemas.Teacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		TeacherProducer teacherProducer = context.getBean(TeacherProducer.class);
		Teacher teacher = Teacher.newBuilder()
							.setIdentifiant(100)
							.setFirstName("simo")
							.setLastName("addoumi")
							.build();
		teacherProducer.send(teacher);
	}

}
