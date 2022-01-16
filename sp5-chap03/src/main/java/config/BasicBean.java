package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import chap03.MemberDao;
import chap03.MemberPrinter;
import chap03.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"spring"})
public class BasicBean {
	
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberPrinter dummyMemberPrinter() {
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
