package shubham.springboot_1.student_server;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    public Student save(Student student) {
//        System.out.println("Student info saved");
//        return student;
//    }
}
