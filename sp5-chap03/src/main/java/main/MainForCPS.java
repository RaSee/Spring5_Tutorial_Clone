package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap03.ChangePasswordService;
import chap03.MemberNotFoundException;
import chap03.WrongIdPasswordException;
import config.MemberConfig;
import config.BasicBean;
import config.ComplexBean;

public class MainForCPS {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfig.class, BasicBean.class, ComplexBean.class);
	
		ChangePasswordService cps = ctx.getBean(ChangePasswordService.class);
		try {
			cps.changePassword("1", "1", "2");
			System.out.println("change pwd complete");
		}catch(MemberNotFoundException e) {
			System.out.println("member not found");
		}catch(WrongIdPasswordException e) {
			System.out.println("pwd is not correct");
		}
		
		ctx.close();
		

	}

}
