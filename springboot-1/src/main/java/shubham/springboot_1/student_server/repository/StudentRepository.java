package shubham.springboot_1.student_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shubham.springboot_1.student_server.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    public Student save(Student student) {
//        System.out.println("Student info saved");
//        return student;
//    }
}
