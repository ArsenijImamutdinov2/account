package ru.astondevs.lab.account;

//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.astondevs.lab.account.model.Beneficiary;
import ru.astondevs.lab.account.repository.BeneficiaryRepository;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
@Log
//@OpenAPIDefinition(info = @Info(title = "Swagger Demo", version = "1.0", description = "Documentation APIs v1.0"))
@EnableAutoConfiguration
//@ComponentScan({"ru.astondevs.lab.account"})
//@EntityScan("ru.astondevs.lab.account.model")
//@EnableJpaRepositories("com.delivery.repository")
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BeneficiaryRepository repository) {

		return (args) -> {
			// save a few customers
//			repository.saveAll(Arrays.asList(new Beneficiary("Jack", 1234, null),
//							new Beneficiary("Chloe", 2345, null),
//							new Beneficiary("Kim", 3456, null),
//							new Beneficiary("David", 4567, null),
//							new Beneficiary("Michelle", 5678, null)))
//					.blockLast(Duration.ofSeconds(10));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().doOnNext(customer -> {
				log.info(customer.toString());
			}).blockLast(Duration.ofSeconds(10));
//
//			log.info("");
//
//			// fetch an individual customer by ID
//			repository.findById("Jack").doOnNext(customer -> {
//				log.info("Customer found with findById('Jack'):");
//				log.info("--------------------------------");
//				log.info(customer.toString());
//				log.info("");
//			}).block(Duration.ofSeconds(10));
//
//
//			// fetch customers by name
//			log.info("Customer found with findByName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByName("Kim").doOnNext(bauer -> {
//				log.info(bauer.toString());
//			}).blockLast(Duration.ofSeconds(10));;
//			log.info("");
		};
	}

}
