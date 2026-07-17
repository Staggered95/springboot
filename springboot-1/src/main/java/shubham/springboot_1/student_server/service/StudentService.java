package shubham.springboot_1.student_server.service;

import org.springframework.stereotype.Service;
import shubham.springboot_1.student_server.entity.Student;
import shubham.springboot_1.student_server.repository.StudentRepository;
import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student studentValidate(Student student) {
        int id = student.getId();
        int age = student.getAge();
        String name = student.getName();
        String department = student.getDepartment();

        if (id < 0 || name==null || age<0 || department==null) return null;
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
