package shubham.springboot_1.portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {

    @GetMapping("/myself")
    public String myself() {
        String me = """
                    <h1>Myself</h1>
                    <h2>Introduction</h2>
                    <p>I am Shubham Singh, a BTech CSE student.</p>
                    <ul>
                    <li>Fullstack web developer</li>
                    <li>I use PERN Stack</li>
                    <li>Likes linux ricing</li>
                    </ul>
                    <br>
                    <h2>Skills</h2>
                    <p>I am proficient in web dev technologies and tools</p>
                    <ul>
                    <li>Languages: HTML, CSS, JS, Node.js</li>
                    <li>Frameworks & Libraries: React, Express, Tailwindcss, Laravel</li>
                    <li>Database: MySQL, PostgreSQL, MongoDB, Redis</li>
                    <li>Tools: VSCode, Neovim, postman, bruno, nginx, docker, EC2, linux</li>
                    </ul>
                    <br>
                    
                """;
        return me;
    }
}
