package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import assembler.Assembler;
import chap03.MemberListPrinter;
import chap03.ChangePasswordService;
import chap03.MemberRegisterService;
import chap03.RegisterRequest;

import chap03.DuplicateMemberException;
import chap03.MemberInfoPrinter;
import chap03.MemberNotFoundException;
import chap03.WrongIdPasswordException;
import config.AppCtx;

public class MainForAssembler {
	
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		BufferedReader reader =
			new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("Input command\n");
			String command = reader.readLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("exit...\n");
				break;
			}
			if(command.startsWith("new ")) {
				processNewCommand(command.split(" "));
			}else if(command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}else if (command.startsWith("list")) {
				processListCommand();
				continue;
			}else if (command.startsWith("info")) {
				processInfoCommand(command.split(" "));
				continue;
			}
			else {
				printHelp();
			}
		}
	}
	
	private static void processNewCommand(String[] arg) {
		if(arg.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.SetName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if(!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("Password and confirmed password are not same\n");
			return;
		}
		try {
			regSvc.regist(req);
			System.out.println("Regist complete\n");
		}catch (DuplicateMemberException e) {
			System.out.println("Ruplicate email\n");
		}
	}
	
	private static void processChangeCommand(String[] arg){
		if (arg.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changPwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			changPwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("Change password complete\n");
		}catch (MemberNotFoundException e) {
			System.out.println("Member not found\n");
		}catch (WrongIdPasswordException e) {
			System.out.println("Email or password is not same\n");
		}
	}
	
	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void processInfoCommand(String[] arg) {
		if (arg.length != 2) {
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}
	
	private static void printHelp() {
		/*
		 * empty function
		 */
	}
	
	
}
