package ufop.web2.luccas.Nameserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NameserverApplication {

	public static void main(String[] args) {

		SpringApplication.run(NameserverApplication.class, args);

		System.out.println("Nameserver Application is Running...");

	}

}
