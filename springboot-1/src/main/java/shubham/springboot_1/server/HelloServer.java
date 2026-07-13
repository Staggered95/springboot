package shubham.springboot_1.server;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloServer {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Shubham!";
    }
}
