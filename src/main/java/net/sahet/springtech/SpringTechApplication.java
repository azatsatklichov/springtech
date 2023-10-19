package net.sahet.springtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import net.sahet.springtech.config.ConfigProperties;
import net.sahet.springtech.config.ConfigPropertiesConversion;
import net.sahet.springtech.config.ConfigPropertiesOnMethod;
import net.sahet.springtech.config.CustomConfigConverter;
import net.sahet.springtech.domain.Ingredient;
import net.sahet.springtech.domain.Ingredient.Type;
import net.sahet.springtech.repository.BookRepository;
import net.sahet.springtech.repository.IngredientRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableSwagger2
/**
 * Note: If we don't use @Configuration in the POJO, then we need to
 * add @EnableConfigurationProperties(ConfigProperties.class) in the main
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

	@Autowired
	IngredientRepository ingredientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringTechApplication.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("StartApplication...");

		// Simple Properties
		log.info("!!! " + configProperties.getHostName() + " !!! ");
		// Nested Properties
		log.info("!!! " + configProperties.getCredentials().getUsername() + " !!! ");
		log.info("!!! " + configProperties.getDefaultRecipients() + " !!! ");

		// Using @ConfigurationProperties on a @Bean Method
		log.info("!!! " + configPropertiesOnMethod.item().getName() + " !!! ");
		log.info("!!! " + configPropertiesOnMethod.item().getSize() + " !!! ");

		// Property Validation - @ConfigurationProperties provides validation of
		// properties using the JSR-303 format
		/**
		 * This helps us reduce a lot of if – else conditions in our code and makes it
		 * look much cleaner and concise.
		 *
		 * If any of these validations fail then the main application would fail to
		 * start with an IllegalStateException.
		 *
		 * The Hibernate Validation framework uses standard Java bean getters and
		 * setters, so it's important that we declare getters and setters for each of
		 * the properties.
		 */
		// Validation WORKS on WEB-Context
		log.info("!!! " + configProperties.getPort() + " !!! ");

		// Property Conversion
		log.info("!!! " + configPropertiesConversion.getTimeInNano() + " !!! ");
		log.info("!!! " + configPropertiesConversion.getTimeInDays() + " !!! ");
		log.info("!!! " + configPropertiesConversion.getSizeInDefaultUnit() + " !!! ");
		log.info("!!! " + configPropertiesConversion.getSizeInTB() + " !!! ");

		// custom converter
		log.info("!!! " + customConfigConverter.convert("merdan,167000") + " !!! ");
		log.info("!!! " + configPropertiesConversion.getEmployee() + " !!! ");
		feedIngredient(ingredientRepository);
	}

	public static void feedIngredient(IngredientRepository repo) {
		repo.save(new Ingredient("Flour Tortilla", Type.WRAP));// "FLTO",
		repo.save(new Ingredient("Corn Tortilla", Type.WRAP));// "COTO",
		repo.save(new Ingredient("Ground Beef", Type.PROTEIN));// "GRBF",
		repo.save(new Ingredient("Carnitas", Type.PROTEIN));// "CARN",
		repo.save(new Ingredient("Diced Tomatoes", Type.VEGGIES));// "TMTO",
		repo.save(new Ingredient("Lettuce", Type.VEGGIES));// "LETC",
		repo.save(new Ingredient("Cheddar", Type.CHEESE));// "CHED",
		repo.save(new Ingredient("Monterrey Jack", Type.CHEESE));// "JACK",
		repo.save(new Ingredient("Salsa", Type.SAUCE));// "SLSA",
		repo.save(new Ingredient("Sour Cream", Type.SAUCE));// "SRCR",
	}
}
