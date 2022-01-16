package chap03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("infoPrinter")
public class MemberInfoPrinter {

	@Autowired
	private MemberDao MemberDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email) {
		Member member = MemberDao.SelectByEmail(email);
		if(member == null) {
			System.out.println("데이터 없음");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
	
	public void setMemberDao(MemberDao MemberDao) {
		this.MemberDao = MemberDao;
	}
	
	@Autowired
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
}
