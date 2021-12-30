package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap03.ChangePasswordService;
import chap03.MemberManager;
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
}
