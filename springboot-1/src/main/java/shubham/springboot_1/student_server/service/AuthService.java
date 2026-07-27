package shubham.springboot_1.student_server.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import shubham.springboot_1.student_server.dto.RegisterRequestDTO;
import shubham.springboot_1.student_server.entity.User;
import shubham.springboot_1.student_server.repository.UserRepository;
import shubham.springboot_1.student_server.security.JwtService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import shubham.springboot_1.student_server.dto.AuthResponseDTO;
import shubham.springboot_1.student_server.dto.LoginRequestDTO;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequestDTO dto) {

        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            return "Username already exists";
        }

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return "User registered";
    }

    public AuthResponseDTO login(LoginRequestDTO dto) {

        authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        String token = jwtService.generateToken(dto.getUsername());

        return new AuthResponseDTO(token);
    }
}