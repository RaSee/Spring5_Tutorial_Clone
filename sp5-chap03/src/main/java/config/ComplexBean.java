package config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import chap03.ChangePasswordService;
import chap03.MemberInfoPrinter;
import chap03.MemberListPrinter;
import chap03.MemberManager;
import chap03.MemberPrinter;
import chap03.MemberRegisterService;

@Configuration
@Import(BasicBean.class)
public class ComplexBean {
	
	@Autowired
	private MemberManager memberManager;
	@Autowired
	private MemberPrinter memberPrinter;
	
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberManager);
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberManager(memberManager);
		return pwdSvc;
	}
	
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberManager, memberPrinter);
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setPrinter(memberPrinter);
		return infoPrinter;
	}
	
}
