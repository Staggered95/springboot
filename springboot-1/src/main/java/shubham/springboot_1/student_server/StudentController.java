package shubham.springboot_1.student_server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    //UPDATE

    //DELETE
}
