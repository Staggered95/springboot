package shubham.springboot_1.student_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import shubham.springboot_1.student_server.service.StudentService;
import shubham.springboot_1.student_server.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //CREATE
    @PostMapping("/student")
    public ResponseEntity<Student> storeStudent(@RequestBody Student student) {
        Student res = studentService.studentValidate(student);
        if (res==null) {
            return ResponseEntity.status(400).body(res);
        }
        return ResponseEntity.status(201).body(res);
    }

    //READ
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {

        Student student = studentService.getStudent(id);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(student);
    }

    //UPDATE

    //DELETE
}
