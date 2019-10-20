package net.sahet.springtech;

import lombok.extern.slf4j.Slf4j;
import net.sahet.springtech.config.ConfigProperties;
import net.sahet.springtech.config.ConfigPropertiesConversion;
import net.sahet.springtech.config.ConfigPropertiesOnMethod;
import net.sahet.springtech.config.CustomConfigConverter;
import net.sahet.springtech.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableSwagger2
/**
 * Note: If we don't use @Configuration in the POJO, then we need to add @EnableConfigurationProperties(ConfigProperties.class) in the main
 */
//@EnableConfigurationProperties(ConfigProperties.class)
@Slf4j
public class SpringTechApplication implements CommandLineRunner {

    @Autowired
    private BookRepository repository;

    @Autowired
    ConfigProperties configProperties;

    @Autowired
    ConfigPropertiesOnMethod configPropertiesOnMethod;

    @Autowired
    ConfigPropertiesConversion configPropertiesConversion;

    @Autowired
    CustomConfigConverter customConfigConverter;

    public static void main(String[] args) {
        SpringApplication.run(SpringTechApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        //Simple Properties
        log.info("!!! " + configProperties.getHostName() + " !!! ");
        //Nested Properties
        log.info("!!! " + configProperties.getCredentials().getUsername() + " !!! ");
        log.info("!!! " + configProperties.getDefaultRecipients() + " !!! ");

        //Using @ConfigurationProperties on a @Bean Method
        log.info("!!! " + configPropertiesOnMethod.item().getName() + " !!! ");
        log.info("!!! " + configPropertiesOnMethod.item().getSize() + " !!! ");

        //Property Validation - @ConfigurationProperties provides validation of properties using the JSR-303 format
        /**
         * This helps us reduce a lot of if – else conditions in our code and makes it look much cleaner and concise.
         *
         * If any of these validations fail then the main application would fail to start with an IllegalStateException.
         *
         * The Hibernate Validation framework uses standard Java bean getters and setters, so it's important that we declare getters and setters for
         * each of the properties.
         */
        //Validation WORKS on WEB-Context
        log.info("!!! " + configProperties.getPort() + " !!! ");


        //Property Conversion
        log.info("!!! " + configPropertiesConversion.getTimeInNano() + " !!! ");
        log.info("!!! " + configPropertiesConversion.getTimeInDays() + " !!! ");
        log.info("!!! " + configPropertiesConversion.getSizeInDefaultUnit() + " !!! ");
        log.info("!!! " + configPropertiesConversion.getSizeInTB() + " !!! ");

        //custom converter
        log.info("!!! " + customConfigConverter.convert("merdan,167000") + " !!! ");
        log.info("!!! " + configPropertiesConversion.getEmployee() + " !!! ");


    }
}
