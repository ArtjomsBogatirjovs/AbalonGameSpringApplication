package lv.bogatiryov.abalongamespringapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AbaloneGameSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbaloneGameSpringApplication.class, args);
    }
}
