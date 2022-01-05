package chap03;

public class MemberInfoPrinter {

	private MemberManager memberManager;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email) {
		Member member = memberManager.SelectByEmail(email);
		if(member == null) {
			System.out.println("데이터 없음");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
	
	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}
	
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
}
