package dudu.cass.numberroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DuduNumberrouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DuduNumberrouteApplication.class, args);
	}
}
