package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chap03.MemberManager;
import chap03.MemberPrinter;
import chap03.VersionPrinter;

@Configuration
public class BasicBean {
	
	@Bean
	public MemberManager memberManager() {
		return new MemberManager();
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(1);
		versionPrinter.setMinorVersion(0);
		
		return versionPrinter;
	}
}
