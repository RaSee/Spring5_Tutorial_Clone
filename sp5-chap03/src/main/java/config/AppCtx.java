package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap03.ChangePasswordService;
import chap03.MemberInfoPrinter;
import chap03.MemberListPrinter;
import chap03.MemberManager;
import chap03.MemberPrinter;
import chap03.MemberRegisterService;

@Configuration
public class AppCtx {
	
	@Bean
	public MemberManager memberManager() {
		return new MemberManager();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberManager());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberManager(memberManager());
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberManager(), memberPrinter());
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemberManager(memberManager());
		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
}
