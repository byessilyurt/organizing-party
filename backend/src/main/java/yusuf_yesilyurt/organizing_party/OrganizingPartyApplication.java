package yusuf_yesilyurt.organizing_party;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("yusuf_yesilyurt.organizing_party.repository")
public class OrganizingPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizingPartyApplication.class, args);
	}

}
