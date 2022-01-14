package assembler;

import chap03.ChangePasswordService;
import chap03.MemberManager;
import chap03.MemberRegisterService;

public class Assembler {

	private MemberManager memberManager;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		memberManager = new MemberManager(null);
		regSvc = new MemberRegisterService(memberManager);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberManager(memberManager);
	}
	
	public MemberManager getMemberManager() {
		return memberManager;
	}
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}
