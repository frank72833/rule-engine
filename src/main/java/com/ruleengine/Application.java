package com.ruleengine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableConfigurationProperties(Properties.class)
@Configuration
public class Application {

	/***********************************************
	 * Private Constants
	 ***********************************************/

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";

	/***********************************************
	 * Private Member Variables
	 ***********************************************/

	private final Environment env;

	/***********************************************
	 * Public Constructor
	 ***********************************************/

	@Autowired
	public Application(Environment env) {
		this.env = env;
	}

	@PostConstruct
	public void initApplication() {
		log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
	}

	/***********************************************
	 * Main method
	 ***********************************************/

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		addDefaultProfile(app);
		app.run(args);
	}

	/***********************************************
	 * Beans
	 ***********************************************/

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
		return propertyPlaceholderConfigurer;
	}

	/***********************************************
	 * Private methods
	 ***********************************************/

	private static void addDefaultProfile(SpringApplication app) {
		Map<String, Object> defProperties = new HashMap<>();
		defProperties.put(SPRING_PROFILE_DEFAULT, Constants.ENVIRONMENT_DEV);
		app.setDefaultProperties(defProperties);
	}
}
