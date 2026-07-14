package shubham.springboot_1.student_server;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {
    //CREATE
    @PostMapping("/student")
    public String storeStudent() {
        return "Student information stored";
    }

    //READ

    //UPDATE

    //DELETE
}
