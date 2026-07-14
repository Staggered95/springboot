package shubham.springboot_1.portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {
    String me = """
                    <h1>Myself</h1>
                    <h2>Introduction</h2>
                    <p>I am Shubham Singh, a BTech CSE student.</p>
                    <ul>
                    <li>Fullstack web developer</li>
                    <li>I use PERN Stack</li>
                    <li>Likes linux ricing</li>
                    </ul>
                """;

    String education = """
                    <h1>My Education</h1>
                    <ul>
                    <li>Class 10th: 95%</li>
                    <li>Class 12th: 64%</li>
                    <li>Current CGPA: 7.5</li>
                    </ul>
                """;

    String skills = """
                <h1>Skills</h1>
                    <p>I am proficient in web dev technologies and tools</p>
                    <ul>
                    <li>Languages: HTML, CSS, JS, Node.js</li>
                    <li>Frameworks & Libraries: React, Express, Tailwindcss, Laravel</li>
                    <li>Database: MySQL, PostgreSQL, MongoDB, Redis</li>
                    <li>Tools: VSCode, Neovim, postman, bruno, nginx, docker, EC2, linux</li>
                    </ul>            
            """;

    String projects = """
                <h1>Projects</h1>
                    <ul>
                    <li><strong>YumeTunes</strong> - Fully functional music streaming site similar to Spotify and YoutubeMusic</li>
                    <li><strong>Slice-of-Rice</strong> - Custome desktop environment using hyprland on arch linux</li>
                    <li><strong>AFC Food</strong> - A simple food listing site with extensive admin panel</li>
                    </ul>
            """;



    @GetMapping("/myself")
    public String myself() {
        return me;
    }

    @GetMapping("/skills")
    public String skills() {
        return skills;
    }

    @GetMapping("/projects")
    public String projects() {
        return projects;
    }

    @GetMapping("/education")
    public String education() {
        return education;
    }
}
