package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("Spring");
		System.out.println(msg);
		
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("g == g2 : " + (g == g2));
		
		ctx.close();
	}

}
