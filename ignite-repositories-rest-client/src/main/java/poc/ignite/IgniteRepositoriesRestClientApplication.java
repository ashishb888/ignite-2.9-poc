package poc.ignite;

import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableIgniteRepositories
@SpringBootApplication
public class IgniteRepositoriesRestClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgniteRepositoriesRestClientApplication.class, args);
	}

}
