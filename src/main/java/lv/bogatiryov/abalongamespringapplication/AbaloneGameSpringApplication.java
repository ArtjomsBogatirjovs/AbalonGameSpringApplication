package lv.bogatiryov.abalongamespringapplication;

import lv.bogatiryov.abalongamespringapplication.db.domain.Player;
import lv.bogatiryov.abalongamespringapplication.db.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EntityScan(value = "lv.bogatiryov.abalongamespringapplication.db.domain")
@EnableJpaRepositories(basePackages = {"lv.bogatiryov.abalongamespringapplication.db.repository"})

@SpringBootApplication
public class AbaloneGameSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbaloneGameSpringApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(PlayerRepository playerRepository) {
        return (args) -> {

            //save a couple of players
            playerRepository.save(new Player("ala",  new BCryptPasswordEncoder().encode("ala")));
            playerRepository.save(new Player("mary",   new BCryptPasswordEncoder().encode("mary")));

        };
    }
}
