package shubham.springboot_1.student_server.service;

import shubham.springboot_1.student_server.dto.StudentCreateRequestDTO;
import shubham.springboot_1.student_server.dto.StudentUpdateRequestDTO;
import shubham.springboot_1.student_server.dto.StudentResponseDTO;

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


    public boolean deleteStudent(int id) {

        if (!studentRepository.existsById(id)) {
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }

    public StudentResponseDTO createStudent(StudentCreateRequestDTO dto) {

        if (dto.getName() == null || dto.getAge() < 0 || dto.getDepartment() == null) {
            return null;
        }

        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setDepartment(dto.getDepartment());

        Student saved = studentRepository.save(student);

        return toResponseDTO(saved);
    }

    public StudentResponseDTO updateStudent(int id, StudentUpdateRequestDTO dto) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setDepartment(dto.getDepartment());

        Student updated = studentRepository.save(student);

        return toResponseDTO(updated);
    }

    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public StudentResponseDTO getStudent(int id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        return toResponseDTO(student);
    }

    private StudentResponseDTO toResponseDTO(Student student) {

        StudentResponseDTO dto = new StudentResponseDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setDepartment(student.getDepartment());
        dto.setCreatedAt(student.getCreatedAt());
        dto.setUpdatedAt(student.getUpdatedAt());

        return dto;
    }
}
