package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.configuration.SqlConfiguration;
import com.example.dao.StudentDao;
import com.example.entity.Student;

@SpringBootApplication
public class Application {

//	@Autowired
//	StudentDao studentDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Application abc = new Application();
		abc.test();
		
	}
	void test(){
		ApplicationContext context = new AnnotationConfigApplicationContext(SqlConfiguration.class);
		StudentDao studentDao =  (StudentDao) context.getBean("studentDao");
		Student student1 = new Student(28,"Dinesh Malik");
		studentDao.persist(student1);
		List<Student> list = studentDao.findAll();
		list.stream().forEach((a)->{a.printDetails();});
		Student student2 = new Student(29,"Deepak Verma");
		studentDao.persist(student2);
		list = studentDao.findAll();
		list.stream().forEach((a)->{a.printDetails();});
	}
	
	
}
