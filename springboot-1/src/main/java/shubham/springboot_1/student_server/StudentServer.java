package shubham.springboot_1.student_server;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {
    //CREATE
    @PostMapping("/student")
    public String storeStudent(@RequestBody Student student) {
        int id = student.getId();
        int age = student.getAge();
        String name = student.getName();
        String department = student.getDepartment();

        return "Name: " + name + " ID: " + id + " Age: " + age + " Department: " + department;
    }

    //READ

    //UPDATE

    //DELETE
}
