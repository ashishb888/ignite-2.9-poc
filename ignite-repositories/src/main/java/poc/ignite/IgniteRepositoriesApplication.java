package poc.ignite;

import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import poc.ignite.service.CacheService;

@EnableIgniteRepositories
@SpringBootApplication
public class IgniteRepositoriesApplication {

	@Autowired
	private CacheService cs;

	public static void main(String[] args) {
		SpringApplication.run(IgniteRepositoriesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			cs.start();
		};
	}
}
