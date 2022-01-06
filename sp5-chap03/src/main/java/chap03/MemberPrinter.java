package chap03;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberPrinter {
	
	
	private DateTimeFormatter dateTimeFormatter;
	
	public void print(Member member) {
		
		System.out.printf(
				"회원 정보: 아이디 = %d, 이메일 = %s, 이름 = %s, 등록일 = %tF\n",
				member.getID(),member.getEmail(), member.getName(), 
				dateTimeFormatter == null ? member.getRegisterDateTime() : dateTimeFormatter.format(member.getRegisterDateTime()));
	}
	
	@Autowired(required = false)
	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}

}
