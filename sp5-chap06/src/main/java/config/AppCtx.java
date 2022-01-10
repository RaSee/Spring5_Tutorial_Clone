package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import chap06.Client;
import chap06.Client2;

@Configuration
public class AppCtx {

	@Bean
	public Client client() {
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	@Scope("prototype")
	public Client2 client2() {
		Client2 client = new Client2();
		client.setHost("Host");
		return client;
	}
}
