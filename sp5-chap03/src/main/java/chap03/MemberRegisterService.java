package chap03;

import java.time.LocalDateTime;

public class MemberRegisterService {

	private MemberManager memberManager;
	
	public MemberRegisterService(MemberManager memberManager) {
		this.memberManager = memberManager;
	}
	
	public Long regist(RegisterRequest req) {
		Member member = memberManager.SelectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("Duplicated email : " + req.getEmail());
		}
		Member newMember = new Member(
						req.getEmail(), req.getPassword(), req.getName(),
						LocalDateTime.now());
		memberManager.insert(newMember);
		return newMember.getID();
	}
	
}
