package shubham.springboot_1.student_server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shubham.springboot_1.student_server.dto.AuthResponseDTO;
import shubham.springboot_1.student_server.dto.LoginRequestDTO;
import shubham.springboot_1.student_server.dto.RegisterRequestDTO;
import shubham.springboot_1.student_server.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequestDTO dto) {

        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(
            @RequestBody LoginRequestDTO dto) {

        return ResponseEntity.ok(authService.login(dto));
    }
}