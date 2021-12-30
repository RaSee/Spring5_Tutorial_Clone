package chap03;



public class ChangePasswordService {

	private MemberManager memberManager;
	
	public void changePassword(String email, String oldPwd, String newPwd) 
			throws MemberNotFoundException, WrongIdPasswordException {
		Member member = memberManager.SelectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberManager.update(member);
	}
	
	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}
}
