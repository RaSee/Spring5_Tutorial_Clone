package chap03;

import java.util.Collection;

public class MemberListPrinter {

		private MemberManager memberManager;
		private MemberPrinter printer;
		
		public MemberListPrinter(MemberManager memberManager, MemberPrinter printer) {
			this.memberManager = memberManager;
			this.printer = printer;
		}
		
		public void printAll() {
			Collection<Member> members = memberManager.selectAll();
			members.forEach(m -> printer.print(m));
		}
	
}
