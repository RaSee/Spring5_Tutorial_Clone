package chap03;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {

		@Autowired
		private MemberManager memberManager;
		@Autowired
		@Qualifier("printer")
		private MemberPrinter printer;
		
		public MemberListPrinter() {
		}
		
		public MemberListPrinter(MemberManager memberManager, MemberPrinter printer) {
			this.memberManager = memberManager;
			this.printer = printer;
		}
		
		public void printAll() {
			Collection<Member> members = memberManager.selectAll();
			members.forEach(m -> printer.print(m));
		}
}
