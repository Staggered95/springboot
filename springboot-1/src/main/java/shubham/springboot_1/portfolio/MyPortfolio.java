package shubham.springboot_1.portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyPortfolio {

    @GetMapping("/myself")
    public String myself() {
        String me = """
                    <h1>Myself</h1>
                    <p>I am Shubham Singh, a BTech CSE student.</p>
                    <ul>
                    <li>Fullstack web developer</li>
                    <li>I use PERN Stack</li>
                    <li>Likes linux ricing</li>
                    </ul>
                """;
        return me;
    }
}
