package chap03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {

	@Autowired
	private MemberDao MemberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd) 
			throws MemberNotFoundException, WrongIdPasswordException {
		Member member = MemberDao.SelectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		MemberDao.update(member);
	}
	
	public void setMemberDao(MemberDao MemberDao) {
		this.MemberDao = MemberDao;
	}
}
