package shubham.springboot_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot1Application.class, args);
		
		Student student = new Student();
		student.setStudent("Rem", 1);

		System.out.println(student.getName());
		System.out.println(student.getRoll());
		System.out.println(student);
	}

}
