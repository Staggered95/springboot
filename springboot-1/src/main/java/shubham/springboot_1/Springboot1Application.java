package shubham.springboot_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import shubham.springboot_1.dependency_injection.OrderService;

@SpringBootApplication
public class Springboot1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springboot1Application.class, args);

//		Student student = context.getBean(Student.class);
//		student.setStudent("Rem", 1);
//
//		System.out.println(student.getName());
//		System.out.println(student.getRoll());
//		System.out.println(student);

//		OrderService orderService = context.getBean(OrderService.class);
//		orderService.placeOrder();

	}

}
