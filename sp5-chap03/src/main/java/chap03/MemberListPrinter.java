package chap03;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("listPrinter")
public class MemberListPrinter {

		@Autowired
		private MemberDao MemberDao;
		@Autowired
		@Qualifier("printer")
		private MemberPrinter printer;
		
		public MemberListPrinter() {
		}
		
		public MemberListPrinter(MemberDao MemberDao, MemberPrinter printer) {
			this.MemberDao = MemberDao;
			this.printer = printer;
		}
		
		public void printAll() {
			Collection<Member> members = MemberDao.selectAll();
			members.forEach(m -> printer.print(m));
		}
}
