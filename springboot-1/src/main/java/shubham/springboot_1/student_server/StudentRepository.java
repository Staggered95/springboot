package shubham.springboot_1.student_server;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public Student save(Student student) {
        System.out.println("Student info saved");
        return student;
    }
}
