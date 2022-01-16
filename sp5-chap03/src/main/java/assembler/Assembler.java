package assembler;

import chap03.ChangePasswordService;
import chap03.MemberDao;
import chap03.MemberRegisterService;

public class Assembler {

	private MemberDao MemberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		MemberDao = new MemberDao(null);
		regSvc = new MemberRegisterService(MemberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(MemberDao);
	}
	
	public MemberDao getMemberDao() {
		return MemberDao;
	}
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}
