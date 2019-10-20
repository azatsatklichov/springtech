package net.sahet.springtech;

import lombok.extern.slf4j.Slf4j;
import net.sahet.springtech.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class SpringTechApplication implements CommandLineRunner {

    @Autowired
    private BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringTechApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");
    }
}
