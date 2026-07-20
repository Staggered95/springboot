package shubham.springboot_1.student_server.controller;
import shubham.springboot_1.student_server.dto.StudentCreateRequestDTO;
import shubham.springboot_1.student_server.dto.StudentUpdateRequestDTO;
import shubham.springboot_1.student_server.dto.StudentResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import shubham.springboot_1.student_server.service.StudentService;
import shubham.springboot_1.student_server.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import jakarta.validation.Valid;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //CREATE
    @PostMapping("/student")
    public ResponseEntity<StudentResponseDTO> createStudent(
            @Valid @RequestBody StudentCreateRequestDTO dto) {

        StudentResponseDTO response = studentService.createStudent(dto);
        return ResponseEntity.status(201).body(response);
    }

    //READ
    @GetMapping("/student")
    public ResponseEntity<List<StudentResponseDTO>> getStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable int id) {

        StudentResponseDTO student = studentService.getStudent(id);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(student);
    }

    //UPDATE
    @PutMapping("/student/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable int id,
            @Valid @RequestBody StudentUpdateRequestDTO dto) {

        StudentResponseDTO response = studentService.updateStudent(id, dto);

        if (response == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(response);
    }

    //DELETE
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {

        boolean deleted = studentService.deleteStudent(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
