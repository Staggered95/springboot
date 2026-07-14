package shubham.springboot_1.student_server;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private String name;
    private int age;
}
