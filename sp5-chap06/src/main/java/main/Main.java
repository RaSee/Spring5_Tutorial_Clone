package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import chap06.Client;
import chap06.Client2;
import config.AppCtx;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx 
			= new AnnotationConfigApplicationContext(AppCtx.class);
		
		Client client = ctx.getBean(Client.class);
		Client client1 = ctx.getBean(Client.class);
		Client2 client2 = ctx.getBean(Client2.class);
		Client2 client21 = ctx.getBean(Client2.class);
		
		client.send();
		client1.send();
		client2.send();
		client21.send();
		
		ctx.close();
		
	}

}
